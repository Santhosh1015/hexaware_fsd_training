package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CustomerDto(
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,

        @NotNull(message = "City is required")
        @NotBlank(message = "City is required")
        String city,

        @NotBlank(message = "Email is Mandatory")
        @Email(message = "Email is Invalid")
        String email,

        @NotBlank(message = "UserName is required")
        @Size(min = 5 , max = 15 , message = "UserName is Invalid")
        String userName,

        @NotBlank(message = "Password is required")
        @Size(min = 8 , max = 12 , message = "Password is Invalid")
        String password
) {
}
