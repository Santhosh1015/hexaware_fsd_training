package com.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.Clock;

@Configuration // it makes the class to managed 1 or more @Beans
@ComponentScan(basePackages = "com.*") // it tells where to search for @service , @repository and so
public class AppConfig {
    static {
        System.out.println("App config loads.....");
    }

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "matrix";
    private static final String DBName = "fsd_java";
    @Bean
    public Clock configureClock(){
        return Clock.systemUTC();
    }

    @Bean
    //DataSource dataSource = new HikariDataSource(config);
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/fsd_java");
        config.setUsername("root");
        config.setPassword("matrix");
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
