package com.springboot.helpdesk.service;

import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
