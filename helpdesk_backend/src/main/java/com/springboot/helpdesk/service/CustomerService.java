package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.CustomerDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.enums.Status;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public void insertCustomer(@Valid CustomerDto customerDto) {
        // step 1. prepare the user object
        User user = new User();
        user.setUserName(customerDto.userName());
        user.setPassword(customerDto.password());
        user.setStatus(Status.ACTIVE);
        user.setRole(Role.CUSTOMER);

        userRepository.save(user);

        //step 2. map CustomerDto to Customer class
        Customer customer = CustomerMapper.mapDtoToCustomer(customerDto);

        //step3. set the user into Customer
        customer.setUser(user);
        customerRepository.save(customer);
    }

    public Customer getCustomerById(long id) {
        Optional<Customer> optional =  customerRepository.findById(id);
        if(optional.isEmpty()){
            throw new ResourceNotFoundException("Invalid customer ID");
        }
        return optional.get();

    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public void deleteCustomerById(long id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
    }
}
