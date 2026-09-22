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

        System.out.println("-----------------All Employees-----------------");
        List<Employee> employees = customerService.getAllEmployees();

        employees.forEach(System.out :: println);

        String dept = "FINANCE";
        try {
            System.out.println("-----------------Employees in " + dept + " Department-----------------");
            List<String> emp_names = customerService.getEmployeeNamesByDept(dept);
            emp_names.forEach(System.out :: println);
            System.out.println("-----------------Count of Employees in " + dept + " Department-----------------");
            int  count = customerService.getEmpCountByDept(dept);
            System.out.println("Count of Employees in " + dept + " Department: " + count);
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}