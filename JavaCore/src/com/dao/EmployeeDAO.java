package com.dao;

import com.enums.Branch;
import com.enums.Department;
import com.model.Employee;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeeDAO {
    public List<Employee> getAllEmployees() {
        return Arrays.asList(
                new Employee(1, "Aarav Sharma", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2021, 3, 12), 85000.0),
                new Employee(2, "Priya Patel", Branch.CHENNAI, "Chennai", Department.ADMIN, LocalDate.of(2019, 7, 1), 62000.0),
                new Employee(3, "John Doe", Branch.PUNE, "New York", Department.FINANCE, LocalDate.of(2022, 1, 15), 110000.0),
                new Employee(4, "Neha Gupta", Branch.MUMBAI, "Pune", Department.DEV, LocalDate.of(2020, 11, 5), 92000.0),
                new Employee(5, "Ramesh Kumar", Branch.CHENNAI, "Vellore", Department.FINANCE, LocalDate.of(2018, 5, 20), 78000.0),
                new Employee(6, "Emily Davis", Branch.PUNE, "Brooklyn", Department.ADMIN, LocalDate.of(2023, 2, 10), 65000.0),
                new Employee(7, "Vikram Singh", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2017, 9, 14), 58000.0),
                new Employee(8, "Ananya Roy", Branch.CHENNAI, "Chennai", Department.DEV, LocalDate.of(2021, 6, 25), 95000.0),
                new Employee(9, "Michael Brown", Branch.PUNE, "Manhattan", Department.DEV, LocalDate.of(2020, 8, 19), 125000.0),
                new Employee(10, "Siddharth Rao", Branch.MUMBAI, "Nagpur", Department.FINANCE, LocalDate.of(2019, 4, 11), 88000.0),
                new Employee(11, "Divya Menon", Branch.CHENNAI, "Coimbatore", Department.ADMIN, LocalDate.of(2022, 10, 3), 51000.0),
                new Employee(12, "Sarah Wilson", Branch.PUNE, "Queens", Department.FINANCE, LocalDate.of(2021, 12, 1), 99000.0),
                new Employee(13, "Karan Joshi", Branch.MUMBAI, "Mumbai", Department.DEV, LocalDate.of(2023, 1, 7), 74000.0),
                new Employee(14, "Deepika Iyer", Branch.CHENNAI, "Madurai", Department.DEV, LocalDate.of(2020, 2, 18), 89000.0),
                new Employee(15, "James Taylor", Branch.PUNE, "Jersey City", Department.ADMIN, LocalDate.of(2019, 6, 30), 72000.0),
                new Employee(16, "Manish Verma", Branch.MUMBAI, "Nashik", Department.FINANCE, LocalDate.of(2022, 9, 14), 67000.0),
                new Employee(17, "Swati Nambiar", Branch.CHENNAI, "Chennai", Department.FINANCE, LocalDate.of(2021, 4, 22), 81000.0),
                new Employee(18, "Robert Johnson", Branch.PUNE, "New York", Department.DEV, LocalDate.of(2018, 10, 5), 140000.0),
                new Employee(19, "Amitabh Sen", Branch.MUMBAI, "Mumbai", Department.ADMIN, LocalDate.of(2020, 7, 12), 53000.0),
                new Employee(20, "Meera Nair", Branch.CHENNAI, "Salem", Department.DEV, LocalDate.of(2023, 3, 19), 96000.0)
        );
    }
}
