package com.helpdesk.service;

import com.helpdesk.model.Customer;
import com.helpdesk.model.Ticket;
import com.helpdesk.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        int customerId = (int)(Math.random()*100000);
        customer.setId(customerId);
        customerRepository.insertCustomer(customer);
    }

    public List<Ticket> getAllTickets(String userName) throws SQLException {
        return customerRepository.getAllTickets(userName);
    }
}
