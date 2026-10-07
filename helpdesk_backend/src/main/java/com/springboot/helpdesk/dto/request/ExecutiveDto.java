package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExecutiveDto(
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,

        @NotBlank(message = "Email is required")
        @Email( message = "Email is Invalid")
        String email,

        @NotBlank(message = "Contact Number is required")
        @Size(min = 10 , max = 10 , message = "ContactNumber must be 10 digit ")
        String contact,

        @NotBlank(message = "UserName is required")
        @Size(min = 5 , max = 15 , message = "UserName is Invalid")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 8 , max = 12 , message = "Password is Invalid")
        String password

) {
}
