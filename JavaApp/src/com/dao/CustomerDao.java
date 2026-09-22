package com.dao;

import com.model.Employee;
import com.utility.DBConnectoin;

import javax.xml.transform.Result;
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

    public List<String> getEmployeeNamesByDept(String dept) throws SQLException {

        List<String> emp_names = new ArrayList<>();
        Connection conn = dbConnectoin.dbConnect();
        String sql = "{CALL emp_by_department(?)}";
        CallableStatement callableStatement = conn.prepareCall(sql);
        callableStatement.setString(1 , dept);
        ResultSet rs = callableStatement.executeQuery();
        while(rs.next()){
            String emp_name = rs.getString("name");
            emp_names.add(emp_name);
        }

        dbConnectoin.DBClose();
        return emp_names;
    }
}
