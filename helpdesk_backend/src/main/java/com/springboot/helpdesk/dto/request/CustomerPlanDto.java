package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record CustomerPlanDto(
        @NotBlank(message = "ActivationDate is required")
        LocalDate activationDate,
        @NotBlank(message = "endDate is required")
        LocalDate endDate,
        String coupon,
        @NotBlank(message = "Amount is required")
        double amountPaid
) {
}
