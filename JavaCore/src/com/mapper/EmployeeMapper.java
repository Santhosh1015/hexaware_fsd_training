package com.mapper;

import com.dto.EmployeeReqDTO;
import com.model.Employee;

public class EmployeeMapper {
    public EmployeeReqDTO empToDTO(Employee employee){
        return new EmployeeReqDTO(
                employee.getId(),
                employee.getName(),
                employee.getBranch(),
                employee.getDepartment(),
                employee.getJoiningDate()
        );
    }
}
