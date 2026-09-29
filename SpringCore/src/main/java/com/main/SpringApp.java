package com.main;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("hikari data source created at loc: "+context.getBean(DataSource.class));
        System.out.println("jdbcTemplate stored at loc: "+context.getBean(JdbcTemplate.class));
    }
}
