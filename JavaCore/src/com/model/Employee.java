package com.model;

import com.enums.Branch;
import com.enums.Department;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private Branch branch;
    private String city;
    private Department department;
    private Double salary;
    private LocalDate joiningDate;


    public Employee() {
    }

    public Employee(int id, String name, Branch branch, String city, Department department, LocalDate joiningDate, Double salary) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.city = city;
        this.department = department;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch=" + branch +
                ", city='" + city + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }

    @Override
    public int compareTo(Employee e2) {
        return e2.getJoiningDate().compareTo(this.getJoiningDate());
    }
}
