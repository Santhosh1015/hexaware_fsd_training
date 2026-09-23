package com.service;

import com.dao.EmployeeDAO;
import com.enums.SortDirection;
import com.model.Employee;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAO();
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public  List<Employee> sortEmpBySalary(List<Employee> employees, SortDirection sortDirection) {
        if(sortDirection.equals(SortDirection.ASE))
            employees.sort((e1 , e2)-> (int) (e1.getSalary() - e2.getSalary()));
        else
            employees.sort((e1 , e2)-> (int) (e1.getSalary() - e2.getSalary()));

        // behind the lambda expressions
//        employees.sort((e1, e2) -> {
//            if(e1.getSalary()>e2.getSalary()){
//                return 1;
//            }else if(e1.getSalary()<e2.getSalary()){
//                return -1;
//            }else{
//                return 0;
//            }

//        });
        return employees;
    }
}
