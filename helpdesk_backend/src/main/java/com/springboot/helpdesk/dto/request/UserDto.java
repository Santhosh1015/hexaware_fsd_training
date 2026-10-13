package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(
        @NotBlank(message = "UserName is required")
        @Size(min = 5 , max = 15 , message = "UserName is Invalid")
        String username,

        @NotBlank(message = "Password is required")
        @Size(min = 8 , max = 12 , message = "Password is Invalid")
        String password


) {

}
