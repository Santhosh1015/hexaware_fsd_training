package com.service;

import com.dao.CustomerDao;
import com.model.Employee;

import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public List<Employee> getAllEmployees() {

        return customerDao.getAllEmployees();
    }

}
