package com.example.app.spring.util;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

//3번쨰
//@Component //<-빈이야~
//@Primary//이걸하면 priority가 올라간다 이거 붙으면 얘 먼저 만들어 우선순위 높아
@Scope("singleton") //singleton(지정하지않으면 싱글톤 스프링 컨테이너 안에서 인스턴스는 하나), prototype(getBean할떄마다 객체가 생김 =(new와 같음)), request,session,application(전체에서 하나 생김)
//@autoWire 통해서 새로 만들어지면 Scope prototype으로 객체 생성 -0-!
public  class DateSequenceGenerator implements BaseSequenceGenerator {
    private String format ="yyyy-MM-dd" ;
    private int initial;
    private SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat(format);// 이런 포맷 형식 많이 쓰니까 알아주기
    //String을 날짜 타입으로 바꿀 때 시간을 날짜 타입으로 바꿀 때 (1) 날짜를 String 타입으로 바꿀 때 날짜를 시간 타입으로 바꿀 때 (2)
    private final AtomicInteger counter = new AtomicInteger();

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public void setFormat(String format) {
        this.format = format;
        this.simpleDateFormat = new SimpleDateFormat(format);
    }

    @Override
    public String getSequence() {
        Date now = new Date();
        StringBuilder builder  = new StringBuilder();
        builder.append(simpleDateFormat.format(new Date()))
                .append("_")
                .append(initial+counter.getAndIncrement());

        return builder.toString();
    }

}