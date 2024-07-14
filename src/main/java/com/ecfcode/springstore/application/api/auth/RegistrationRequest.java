package com.ecfcode.springstore.application.api.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
        @NotEmpty(message = "FirstName is mandatory")
        @NotBlank(message = "FirstName is mandatory")
        String firstName,

        @NotEmpty(message = "LastName is mandatory")
        @NotBlank(message = "LastName is mandatory")
        String lastName,

        @Email(message = "Email is not formatted")
        @NotEmpty(message = "Email is mandatory")
        @NotBlank(message = "Email is mandatory")
        String email,

        @NotEmpty(message = "PassWord is mandatory")
        @Size(min = 8, max = 30, message = "Password should be between 8 and 30 Characters")
        @NotBlank(message = "PassWord is mandatory")
        String password) {
}
