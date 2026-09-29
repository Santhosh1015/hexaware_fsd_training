package com.main;

import com.config.AppConfig;
import com.service.DemoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // from here class the appconfig class loads where we have multiple beans

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Main Class..");
//        DemoService service = new DemoService();// POJO here...
        DemoService service = context.getBean(DemoService.class); // by getting the object from the config class using ApplicationConext
        service.test();
    }

    /*
ApplicationContext
        | implements
AnnotationConfigApplicationContext

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); -- Polymorphic
   */
}