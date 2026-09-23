package com.dto;

import com.enums.Branch;
import com.enums.Department;

import java.time.LocalDate;

public record EmployeeReqDTO(
        int id,
        String name,
        Branch branch,
        Department department,
        LocalDate joiningDate

) {
}
