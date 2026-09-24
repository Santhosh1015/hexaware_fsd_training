package com.dto;

import com.enums.Branch;

public record EmpBranchStatDTO(
        Branch branch,
        Double salary
) {
}
