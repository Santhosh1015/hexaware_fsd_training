package com.springboot.helpdesk.config;

import com.springboot.helpdesk.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    public final MyUserDetailsService myUserDetailsService;

    /*
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
    */

    @Bean// hardly took 30 min to identify bean is not configured
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // exploit protection - Cross Site Protection Forgery(csrf)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST , "/api/customer/add").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/customer/{id}").hasAuthority("CUSTOMER") // letting the rle to access this url
                        .requestMatchers(HttpMethod.POST,"/api/ticket/add").hasAuthority("CUSTOMER")
                        .requestMatchers(HttpMethod.PUT , "/api/ticket/assign/{ticketId}/{executiveId}").hasAuthority("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/executive/add").hasAuthority("MANAGER")
                        .requestMatchers(HttpMethod.POST , "/api/manager/add").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST , "/api/admin/add").denyAll()
                        .anyRequest().permitAll()
                );
        http.httpBasic(Customizer.withDefaults()); // tells security to go with basic Auth
        return http.build();
    }

    @Bean
    public AuthenticationProvider getProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(myUserDetailsService);

        authenticationProvider.setPasswordEncoder(getEncoder());

        return authenticationProvider;

    }
    @Bean
    public PasswordEncoder getEncoder(){

        //Bcrypt hashing algo
        return new BCryptPasswordEncoder();
    }

}
