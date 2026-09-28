package com.service;

import com.dto.EmployeeRespDTO;
import com.enums.Department;
import com.enums.SortDirection;
import com.exception.InvalidInputException;
import com.exception.InvalidListException;
import com.map.EmployeeMapper;
import com.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    public List<Employee> sortEmpBySalary(List<Employee> employees, SortDirection sortDirection) {

        if(employees == null || employees.isEmpty()){
            throw new InvalidListException("list can't be null or empty");
        }
        if(sortDirection.equals(SortDirection.ASE))
            employees.sort((e1 , e2)-> (int) (e1.getSalary() - e2.getSalary()));
        else
            employees.sort((e1 , e2)-> (int) (e2.getSalary() - e1.getSalary()));

        return employees;
    }


    public List<EmployeeRespDTO> getAllEmployeesInfo(List<Employee> employees) {

        if(employees == null || employees.isEmpty()){
            throw new InvalidListException("list can't be null or empty");
        }
        EmployeeMapper eM= new EmployeeMapper();
        return employees
                .stream()
                .map(  eM::empToDtoMapper)
                .collect(Collectors.toList());
    }

    public List<Employee> filterEmployeeByDept(List<Employee> employees, Department department) {

        if(employees == null || employees.isEmpty()){
            throw new InvalidListException("list can't be null or empty");
        }
        if(department == null){
            throw new InvalidInputException("Department should not be null");
        }
        return employees
                .stream()
                .filter(e->e.getDepartment().equals(department))
                .toList();
    }
}
