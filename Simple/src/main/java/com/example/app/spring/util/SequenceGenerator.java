package com.example.app.spring.util;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//2번쨰 생성

import java.util.concurrent.atomic.AtomicInteger;

//@Component //<-Spring 빈이야~
@Scope("singleton") //singleton(지정하지않으면 싱글톤), prototype(getBean할떄마다 생김), request,session,application
public class SequenceGenerator implements BaseSequenceGenerator {
    private String prefix;
    private String suffix;
    private int initial;

    private final AtomicInteger counter;// = new AtomicInteger();//동시성 문제에서 증가하고 싶거나 감소하고 싶을 때 이거 써야 함
    //얘를 저장하고 갖고 오는 방법

    public SequenceGenerator(){
        this.counter = new AtomicInteger(); //생성자에서 만들어 바로 지금

    }// 디버깅용 생성자 만들기

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    public void setInitial(int initial) {
        this.initial = initial;
    }

    @Override
    public String getSequence() {
        StringBuilder builder = new StringBuilder(); ///그냥 add하는 것보다 빠르기 때문에 StringBuilder 이런 패턴을 빌더 패턴이라고 한다.
        builder.append(prefix) //빌더 패턴은 파라미터가 많을 때 사용한다. 이거 없으면 생성자에다가 param 넘겨줌 빌드가 생성된 시점에서 객체가 생성
                .append(initial)
                .append(counter.getAndIncrement())
                //시퀀스 값을 저장했다가 복원하는 방법 생각해오기 - 6.26 숙제
                .append(suffix);
        return builder.toString();//이때 스트링 생김
    }

}
