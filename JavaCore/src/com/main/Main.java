package com.main;

import com.enums.SortDirection;
import com.model.Employee;
import com.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();
        employees = employeeService.getAllEmployees();
        employees.forEach(System.out :: println);
        System.out.println("----------Sort Employees By their Salary----------");
        List<Employee> sortedEmp = new ArrayList<>();
        sortedEmp = employeeService.sortEmpBySalary(employees , SortDirection.ASE);
        employees.forEach(System.out :: println);
    }
}