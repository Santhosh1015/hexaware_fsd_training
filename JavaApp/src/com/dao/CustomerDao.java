package com.dao;

import com.model.Employee;
import com.utility.DBConnectoin;

import java.sql.*;
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

    public int getEmpCountByDept(String dept) throws SQLException {
       Connection conn = dbConnectoin.dbConnect();

        String sql ="{call count_emp_by_dept(?,?)}" ;
        //prepare callable statement
        CallableStatement cs = conn.prepareCall(sql);
        cs.setString(1, dept);
        //register output parameter
        cs.registerOutParameter(2 , Types.INTEGER);
        //execute the callable statement
        cs.execute();
        //store the output parameter value in a variable
        int count = cs.getInt(2);
        dbConnectoin.DBClose();
        return count;
    }
}
