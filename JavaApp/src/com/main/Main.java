package com.main;

import com.model.Employee;
import com.service.CustomerService;
import com.utility.DBConnectoin;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        List<Employee> employees = customerService.getAllEmployees();

        employees.forEach(System.out :: println);

        String dept = "FINANCE";
        try {
            List<String> emp_names = customerService.getEmployeeNamesByDept(dept);
            emp_names.forEach(System.out :: println);
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}