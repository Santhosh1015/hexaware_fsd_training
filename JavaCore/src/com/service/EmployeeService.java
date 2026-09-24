package com.service;

import com.dao.EmployeeDAO;
import com.dto.EmployeeRespDTO;
import com.enums.Branch;
import com.enums.Department;
import com.enums.SortDirection;
import com.mapper.EmployeeMapper;
import com.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Employee> filterEmployeeByDept(List<Employee> employees, Department department) {

        return employees
                .stream()
                .filter(e->e.getDepartment().equals(department))
                .toList();
//
         //  this is what happening behind the stream logic

//        Stream<Employee> emp = employees.stream();
//        emp = emp.filter(e->e.getDepartment().equals(department));
//        return emp.toList();


    }

    public List<Employee> filterAndSortEmployeeByBranch(List<Employee> employees, Branch branch) {

        return employees
                .stream()
                .filter(e -> e.getBranch().equals(branch))
                .sorted((e1,e2)-> e1.getJoiningDate().compareTo(e2.getJoiningDate()))
                .collect(Collectors.toList());
    }

    public List<EmployeeRespDTO> getAllEmployeesInfo(List<Employee> employees) {
        EmployeeMapper eM= new EmployeeMapper();
            return employees
                    .stream()
                    .map(  eM::empToDTO)
                    .collect(Collectors.toList());
    }

    public Map<Department, Long> getEmpCountByDept(List<Employee> employees) {
        return employees
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }
}
