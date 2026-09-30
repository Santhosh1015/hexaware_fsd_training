package com.helpdesk.controller;

import com.helpdesk.config.AppConfig;
import com.helpdesk.enums.Plan;
import com.helpdesk.enums.Role;
import com.helpdesk.exceptions.InvalidCredentialsException;
import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import com.helpdesk.model.User;
import com.helpdesk.service.CustomerService;
import com.helpdesk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
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
                    System.out.println("------------ Signup Page ------------");
                    Customer customer = new Customer();
                    User user = new User();
                    // taken input from user/customer
                    // personal info goes in a Customer object using setter or constructor
                    System.out.println("Enter the name: ");
                    customer.setName(sc.next());
                    sc.nextLine();

                    System.out.println("Enter the Age: ");
                    customer.setAge(sc.nextInt());

                    System.out.println("Select Plan: ");
                    Arrays.stream(Plan.values()).forEach(System.out::println);
                    customer.setPlan(Plan.valueOf(sc.next().toUpperCase()));

                    // credentials info goes in a User object
                    System.out.println("--lets enter your login credentials--");
                    System.out.println("Enter the username: ");
                    user.setUsername(sc.next());

                    System.out.println("Enter the Password: ");
                    user.setPassword(sc.next());

                    user.setRole(Role.CUSTOMER);
                    user.setActive(true);

                    try {
                        // give these objects to service classes which will save them in DB
                        userService.createUser(user);
                    } catch (RuntimeException e) {
                        System.out.println( e.getMessage());
                    }

                    // set the user as the foreign key for the customers
                    customer.setUser(user);

                    try {
                        // give these objects to service classes which will save them in DB
                        customerService.createCustomer(customer);
                    } catch (RuntimeException e) {
                        System.out.println( e.getMessage());
                    }

                    System.out.println("Sign Up Success...Here you go.....");
                    break;
                }
                case 2 -> {
                    System.out.println("---------Customer login----------");
                    System.out.println("Enter the UserName: ");
                    String userName = sc.next();
                    System.out.println("Enter the Password: ");
                    String password = sc.next();


                    try {
                        User user = userService.login(userName , password);
                        System.out.println("---------Logged In successfully----------");
                        System.out.println("Welcome to HelpDesk Application : "+userName);

                        if (user.getRole().equals(Role.CUSTOMER)) {
                            System.out.println("---------Customer Menu----------");
                            System.out.println("Enter 1 to see All your Tickets.");
                            System.out.println("Enter 0 to exit from Customer Menu.");
                            if(sc.nextInt() == 1){
                                List<Ticket> ticketsList = customerService.getAllTickets(userName);
                                ticketsList.forEach(System.out::println);
                            }
                        }
                    } catch (InvalidCredentialsException e) {
                        throw new InvalidCredentialsException("Invalid Credentials...");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
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
