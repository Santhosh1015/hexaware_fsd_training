package com.dao;

import com.model.Employee;
import com.utility.DBConnectoin;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private DBConnectoin dbConnectoin = new DBConnectoin();


    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection conn = dbConnectoin.dbConnect();

        //calling procedure to get all employees
        String sql = "{CALL all_emp()}";
        try{
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()){
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setBranch(rs.getString("branch"));
                employee.setCity(rs.getString("city"));
                employee.setDepartment(rs.getString("department"));

                list.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnectoin.DBClose();
        return list;

    }
}
