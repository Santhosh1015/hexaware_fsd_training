package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor // this annotation for the creation constructors for the variable that need constructor
                        //like for this public final CustomerService customerService;
public class CustomerController {

    public final CustomerService customerService;

    // requestMapping is the specialized annotation of GetMapping PostMapping etc..
    //@RequestMapping is the general api for the model like @RequestMapping("/api/customer")
    //the GetMapping("/add) the api actually was "/api/customer/add"
    @PostMapping("/api/customer/add")
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/api/customer/{id}")
    public Customer getCustomerById(@PathVariable  long id){
       return customerService.getCustomerById(id);


    }

    @GetMapping("/api/customer/all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @DeleteMapping("/api/customer/delete/{id}")
    public void deleteCustomerById(@PathVariable long id){
        customerService.deleteCustomerById(id);
    }

}
