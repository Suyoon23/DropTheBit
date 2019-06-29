package com.example.app.spring.context;
//1번쨰 만듦
import com.example.app.spring.service.OrderService;
import com.example.app.spring.service.OrderServiceImpl;
import com.example.app.spring.util.BaseSequenceGenerator;
import com.example.app.spring.util.DateSequenceGenerator;
import com.example.app.spring.util.SequenceGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration //어떤 빈즈를 쓸것이냐 -> 이게 붙었으니까 main에서 AnnotationConfigApplicationContext를 쓸 수 있는 것이다.
@ComponentScan( basePackages = {"com.example.app.spring"})//그룹 아이디 한 것을 여따가 넣기 현재 compo = 빈즈를 어떤 패키지 안에서 찾을 것이냐
public class SimpleApplicationContext {

    @Bean //빈즈라고 선언할 때는 Seq.Gene에서 @Component라고 (빈)라고 선언할 필요가 없다.
    //근데 뽀로롱 뽀니들이 메인 구멍 뚫린 자리에 가고 Bean 선언 안했으면 Componenet 선언해야함
    @Primary
    public BaseSequenceGenerator getSequenceGenerator(){
        SequenceGenerator generator = new SequenceGenerator();
        generator.setPrefix("_뽀니야!_");
        generator.setSuffix("_뽀로롱뽀니야아!_");
        generator.setInitial(20000);
        return generator;
       // DateSequenceGenerator generator = new DateSequenceGenerator(); //일반 클래스를 가져다가 선언해줘도 bean이 된다.
       // generator.setFormat("yyyyMMdd");
       // generator.setInitial(10000);
//        return generator;
    }


//    @Bean
//    public OrderService getOrderService(){
//    //Method 1: by constructor
//    //return new OrderServiceImpl(getSequenceGenerator());
//    //Mehtod 2: by setter
////    OrderServiceImpl orderService = new OrderServiceImpl() ;
////        orderService.setSequenceGenerator(getSequenceGenerator());
////        return orderService;
//
//        return  new OrderServiceImpl();

        }


