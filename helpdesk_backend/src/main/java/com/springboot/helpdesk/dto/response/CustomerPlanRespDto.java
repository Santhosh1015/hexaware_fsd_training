package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.PlanType;

import java.time.LocalDate;

public record CustomerPlanRespDto(
        String CustomerName,
        PlanType planType,
        double amountPaid,
        LocalDate activationDate,
        LocalDate endDate,
        String coupon



) {
}
