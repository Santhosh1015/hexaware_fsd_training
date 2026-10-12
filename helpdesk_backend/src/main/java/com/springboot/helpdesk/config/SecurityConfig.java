package com.springboot.helpdesk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService users() {
        UserDetails customer1 = User.builder()
                .username("customer1")
                .password("{noop}customer1")
                .authorities("CUSTOMER")
                .build();
        UserDetails executive1 = User.builder()
                .username("executive1")
                .password("{noop}executive1")
                .authorities("EXECUTIVE")
                .build();
        UserDetails manager1 = User.builder()
                .username("manager1")
                .password("{noop}manager1")
                .authorities("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(customer1, executive1, manager1);
    }
    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // exploit protection - Cross Site Protection Forgery(csrf)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/customer/add").hasAuthority("CUSTOMER") // letting the rle to access this url
                        .anyRequest().permitAll()
                );
        http.httpBasic(Customizer.withDefaults()); // tells security to go with basic Auth
        return http.build();
    }
}
