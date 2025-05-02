package com.example.spring_security_service_01.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(
        @RequestBody @Valid RegisterRequest request
    ) throws MessagingException{

        authService.registration(request);
        return ResponseEntity.accepted().build();

    }


    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
    @RequestBody AuthenticationRequest request
    ){

        return ResponseEntity.ok(authService.authenticate(request));
    }
    
}
