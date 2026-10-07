package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ManagerDto(
        @NotBlank(message = "name is required")
        @Size(min = 8 , max = 15 , message = "Invalid Name")
        String name,

        @NotBlank(message = "username is required")
        @Size(min = 8 , max = 15 , message = "Invalid UserName")
        String userName,

        @NotBlank(message = "password is required")
        @Size(min = 8 , max = 15 , message = "Invalid Password")
        String password
) {}
