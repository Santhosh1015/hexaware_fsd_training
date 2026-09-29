package com.config;

import org.springframework.context.annotation.Configuration;

@Configuration // it makes the class to managed 1 or more @Beans
public class AppConfig {
    static {
        System.out.println("App config loads.....");
    }
}
