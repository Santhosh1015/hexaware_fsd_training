package com.main;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // from here class the appconfig class loads where we have multiple beans

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Main Class..");
    }
    
    /*
ApplicationContext
        | implements
AnnotationConfigApplicationContext

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); -- Polymorphic
   */
}