package com.mapper;

import com.dto.EmployeeRespDTO;
import com.model.Employee;

public class EmployeeMapper {
    public EmployeeRespDTO empToDTO(Employee employee){
        return new EmployeeRespDTO(
                employee.getId(),
                employee.getName(),
                employee.getBranch(),
                employee.getDepartment(),
                employee.getJoiningDate()
        );
    }
}
