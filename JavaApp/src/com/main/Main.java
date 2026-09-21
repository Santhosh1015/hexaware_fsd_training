package com.main;

import com.model.Employee;
import com.service.CustomerService;
import com.utility.DBConnectoin;

import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        List<Employee> employees = customerService.getAllEmployees();

        employees.forEach(System.out :: println);
    }
}