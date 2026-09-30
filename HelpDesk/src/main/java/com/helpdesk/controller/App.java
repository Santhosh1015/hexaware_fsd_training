package com.helpdesk.controller;

import com.helpdesk.config.AppConfig;
import com.helpdesk.service.CustomerService;
import com.helpdesk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        UserService userService = context.getBean(UserService.class);



        while(true) {

            System.out.println("----------HELPDESK APP------------");
            System.out.println("1. Customer Signup");
            System.out.println("2. Customer Login");
            System.out.println("3. Executive Login");
            System.out.println("0. to Exit");
            System.out.println("-----------------------------------");
            System.out.print("Please Select a option : ");
            int input = sc.nextInt();


            if (input == 0) {
                System.out.println("-------------Exiting.-----------");
                return;
            }
            switch (input) {
                case 1 -> {
                    System.out.println("Customer sign up");
                    // taken input from user/customer
                    // personal info goes in Customer object using setter or constructor
                    // credentials info goes in User object
                    // give these objects to service classes which will save them in DB
                    System.out.println("Sign Up Success");
                    break;
                }
                case 2 -> {
                    System.out.println("Customer login");
                    break;
                }
                default -> {
                    System.out.println("Invalid option..");
                    return;
                }
            }
        }
    }
}
