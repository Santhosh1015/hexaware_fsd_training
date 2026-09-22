package com.service;

import com.dao.CustomerDao;
import com.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();

    public List<Employee> getAllEmployees() {

        return customerDao.getAllEmployees();
    }

    public List<String> getEmployeeNamesByDept(String dept) throws SQLException {
        return customerDao.getEmployeeNamesByDept(dept);
    }
}
