package com.example.app.spring3;

import com.example.app.spring3.context.PhoneBookApplicationContext;
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
        ApplicationContext context =
                new AnnotationConfigApplicationContext(PhoneBookApplicationContext.class);

    }
}
