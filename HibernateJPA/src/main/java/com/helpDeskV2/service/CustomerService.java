package com.helpDeskV2.service;

import com.helpDeskV2.model.Customer;
import com.helpDeskV2.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository ;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void insert(String name, String city) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customerRepository.insert(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
