package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // it makes the class to managed 1 or more @Beans
@ComponentScan(basePackages = "com.*") // it tells where to search for @service , @repository and so
public class AppConfig {
    static {
        System.out.println("App config loads.....");
    }
}
