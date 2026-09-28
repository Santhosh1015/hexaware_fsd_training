package com.service;

import com.dto.EmployeeRespDTO;
import com.enums.Branch;
import com.enums.Department;
import com.enums.SortDirection;
import com.exception.InvalidInputException;
import com.exception.InvalidListException;
import com.model.Employee;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {

    // for the sort the employees method
    EmployeeService employeeService;
    List<Employee> list;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;
    private Employee employee7;

    // for the getEMployeeInfo Unit test
    List<EmployeeRespDTO> employeeDTOS ;
    private EmployeeRespDTO employeeRespDTO1;
    private EmployeeRespDTO employeeRespDTO2;
    private EmployeeRespDTO employeeRespDTO3;
    private EmployeeRespDTO employeeRespDTO4;

    // filterEmployees by department method test


    @BeforeEach
    public void init(){
        employeeService = new EmployeeService();
        employee1 = new Employee(1, "Aarav Sharma", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 3, 12), 85000.0);
        employee2 =new Employee(2, "Priya Patel", Branch.CHENNAI, "Chennai", Department.ADMIN, LocalDate.of(2019, 7, 1), 62000.0);
        employee3 = new Employee(3, "John Doe", Branch.PUNE, "New York", Department.FINANCE, LocalDate.of(2022, 1, 15), 110000.0);
        employee4 = new Employee(4, "Neha Gupta", Branch.MUMBAI, "Pune", Department.DEV, LocalDate.of(2020, 11, 5), 92000.0);
        employee5 = new Employee(5, "Ramesh Kumar", Branch.CHENNAI, "Vellore", Department.FINANCE, LocalDate.of(2018, 5, 20), 78000.0);
        employee6 = new Employee(6, "Emily Davis", Branch.PUNE, "Brooklyn", Department.ADMIN, LocalDate.of(2023, 2, 10), 65000.0);
        employee7 = new Employee(7, "Vikram Singh", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2017, 9, 14), 58000.0);

        list = Arrays.asList(employee1,employee2,employee3,employee4,employee5,employee6,employee7);

        employeeRespDTO1 = new EmployeeRespDTO(1 ,"Aarav Sharma" ,Branch.MUMBAI ,Department.DEV ,  LocalDate.of(2021, 3, 12) );
        employeeRespDTO2 = new EmployeeRespDTO(3 ,"John Doe" , Branch.PUNE ,Department.FINANCE , LocalDate.of(2022, 1, 15)  );
        employeeRespDTO3 = new EmployeeRespDTO(2 ,"Priya Patel" , Branch.CHENNAI,Department.ADMIN, LocalDate.of(2019, 7, 1)  );
        employeeDTOS = Arrays.asList(employeeRespDTO1 , employeeRespDTO2 , employeeRespDTO3);



    }
    @Test
    public void sortEmpBySalaryTest(){
        assertThrows(InvalidListException.class , ()-> employeeService.sortEmpBySalary(List.of() , SortDirection.DSEC));
        assertThrows(InvalidListException.class , ()-> employeeService.sortEmpBySalary(null , SortDirection.DSEC));


        List<Employee> expectedList = Arrays.asList(employee7, employee2 , employee6 , employee5, employee1 , employee4 , employee3);
        assertEquals(expectedList , employeeService.sortEmpBySalary(list , SortDirection.ASE));

        assertEquals(expectedList.reversed() , employeeService.sortEmpBySalary(list , SortDirection.DSEC));

    }

    @Test
    public void getAllEmployeesInfoTest(){
        assertThrows(InvalidListException.class ,() -> employeeService.getAllEmployeesInfo(List.of()));
        assertEquals(employeeDTOS , employeeService.getAllEmployeesInfo(Arrays.asList(employee1 , employee3 , employee2)));
    }

    @Test
    public void filterEmployeeByDeptTest(){
        assertThrows(InvalidListException.class , ()-> employeeService.filterEmployeeByDept(List.of() , Department.DEV));
        assertThrows(InvalidInputException.class , ()-> employeeService.filterEmployeeByDept(list , null));

        List<Employee> expectedEmpDept = Arrays.asList(employee2 , employee6, employee7);
        assertEquals(expectedEmpDept , employeeService.filterEmployeeByDept(list , Department.ADMIN));
    }

    @AfterEach
    public void destroy(){
        employeeService = null;
    }

}
