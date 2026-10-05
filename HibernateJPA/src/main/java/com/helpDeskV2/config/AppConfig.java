package com.helpDeskV2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.helpDeskV2")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/helpdeskv2");
        dataSource.setUsername("root");
        dataSource.setPassword("matrix");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        // set the datasource to communicate with DB using credentials
        entityManagerFactoryBean.setDataSource(getDataSource());

        // this tells where to look for the @Entity classes
        entityManagerFactoryBean.setPackagesToScan("com.helpDeskV2.model");

        // from jpa have two vendors 1.eclipse and 2. hibernate - specify the hibernateJpsVendor
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);

        // set the properties to how hibernate communicates with db
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto","update"); // hibernate mapper to ddl, update, none, create like we can modify command
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        entityManagerFactoryBean.setJpaProperties(properties);


        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
//        return new JpaTransactionManager(getEntityFactory().getNativeEntityManagerFactory()) // this is the system inbuilt entityManager
        return new JpaTransactionManager(Objects.requireNonNull(getEntityFactory().getObject())); // this is our own-configured class

    }
}
