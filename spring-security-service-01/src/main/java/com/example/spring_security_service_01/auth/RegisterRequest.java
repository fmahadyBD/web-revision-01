package com.example.spring_security_service_01.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RegisterRequest {

    @NotEmpty(message = "Name is mandatory")
    @NotNull(message = "Name is mandatory")

    private String name;

    @NotEmpty(message = "Email is mandatory")
    @NotNull(message = "Email is mandatory")
    @Email(message = "Email is not well formated")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @NotNull(message = "Password is mandatory")
    @Size(min = 8, message = "Passowrd should be 8 charecter long minimum")
    private String passowrd;

}