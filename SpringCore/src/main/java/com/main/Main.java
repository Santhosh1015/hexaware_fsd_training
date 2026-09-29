package com.main;

import com.config.AppConfig;
import com.dao.DemoDAO;
import com.mapper.DemoMapper;
import com.service.DemoService;
import com.utility.DemoUtility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // from here class the appconfig class loads where we have multiple beans

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Main Class..");
//        DemoService service = new DemoService();// POJO here...

        DemoService service = context.getBean(DemoService.class); // by getting the object from the config class using ApplicationContext

        service.test(context.getBean(DemoDAO.class),
                    context.getBean(DemoMapper.class),
                    context.getBean(DemoUtility.class));
    }

    /*
ApplicationContext
        | implements
AnnotationConfigApplicationContext

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); -- Polymorphic
   */
}