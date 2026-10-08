package com.springboot.helpdesk.dto.request;

import com.springboot.helpdesk.enums.PlanType;

public record PlanDto(
        PlanType planType,
        Double price
) {
}
