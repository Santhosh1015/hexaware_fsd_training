package com.dto;

import com.enums.Department;

public record EmpDeptStatDTO(
        Department department,
        Long numberOfEmployees
) {
}
