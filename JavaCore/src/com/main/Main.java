package com.main;

import com.dto.EmpDeptStatDTO;
import com.dto.EmployeeRespDTO;
import com.enums.Branch;
import com.enums.Department;
import com.model.Employee;
import com.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();
        employees = employeeService.getAllEmployees();
//        employees.forEach(System.out :: println);
//        System.out.println("----------Sort Employees By their Salary----------");
//        List<Employee> sortedEmp = new ArrayList<>();
//        sortedEmp = employeeService.sortEmpBySalary(employees , SortDirection.ASE);
//        employees.forEach(System.out :: println);
//        System.out.println("----------filter Employees By Department----------");
//        List<Employee> filterEmpByDeptList = new ArrayList<>();
//        filterEmpByDeptList = employeeService.filterEmployeeByDept(employees , Department.DEV);
//        filterEmpByDeptList.forEach(System.out :: println);
//
//        System.out.println("----------filter Employees By Branch, sorted by Joining Date----------");
//        List<Employee> filterEmpByBranchList = employeeService.filterAndSortEmployeeByBranch(employees, Branch.CHENNAI);
//        filterEmpByBranchList.forEach(System.out::println);
//
//        System.out.println("----------Get the Employee Info using DTO----------");
//        List<EmployeeRespDTO> empInfo  = employeeService.getAllEmployeesInfo(employees);
//        empInfo.forEach(System.out :: println);

        System.out.println("----------Get the Count of Employee Based On Departments----------");
        List<EmpDeptStatDTO> list = employeeService.getEmpCountByDept(employees);
        list.forEach(System.out::println);
    }
}