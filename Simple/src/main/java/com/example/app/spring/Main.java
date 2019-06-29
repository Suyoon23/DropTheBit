package com.example.app.spring;

import com.example.app.spring.context.SimpleApplicationContext;
import com.example.app.spring.service.OrderService;
import com.example.app.spring.util.BaseSequenceGenerator;
import com.example.app.spring.util.DateSequenceGenerator;
import com.example.app.spring.util.SequenceGenerator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext (SimpleApplicationContext.class);//1
        OrderService service = context.getBean(OrderService.class);//2
        BaseSequenceGenerator generator = context.getBean(BaseSequenceGenerator.class);//3(2개 Date, Basic)
        service.addOrder("kaylee.an", "0x12345", 100.90);//4
        //    SequenceGenerator generator = context.getBean(SequenceGenerator.class);
        //뽀로롱 뽀니들 원래 ㅁㅔ인 자리
     //   SequenceGenerator sequenceGenerator; //= new SequenceGenerator();
       // DateSequenceGenerator sequenceGenerator = new DateSequenceGenerator();
      //  sequenceGenerator.setPrefix("뽀니");
      //  sequenceGenerator.setFormat("");
    //    sequenceGenerator.setInitial(20000);
      //  sequenceGenerator.setSuffix("개 사랑해");

        System.out.println( "sequence : " + generator.getSequence() );
        System.out.println( "sequence : " + generator.getSequence() );

    }


}
