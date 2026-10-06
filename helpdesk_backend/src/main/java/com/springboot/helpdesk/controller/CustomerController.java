package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    public final CustomerService customerService;

    @PostMapping("/api/customer/add")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }
}
