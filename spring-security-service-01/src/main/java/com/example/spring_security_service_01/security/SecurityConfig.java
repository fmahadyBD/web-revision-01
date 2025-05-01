package com.example.spring_security_service_01.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {


    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
        .cors(Customizer.withDefaults())  // Enables CORS with default settings
        .csrf(AbstractHttpConfigurer::disable)  // Disables CSRF protection (since you're using stateless JWT authentication)
        .authorizeHttpRequests(req ->
                req.requestMatchers(
                                "/auth/**",  // Allow unauthenticated access to authentication endpoints
                                "/v2/api-docs",  // Swagger docs endpoints
                                "/v3/api-docs",  // Swagger docs endpoints
                                "/v3/api-docs/**",  // Swagger docs endpoints
                                "/swagger-resources",  // Swagger resources
                                "/swagger-resources/**",  // Swagger resources
                                "/configuration/ui",  // Swagger UI configuration
                                "/configuration/security",  // Swagger security configuration
                                "/swagger-ui/**",  // Swagger UI
                                "/swagger-ui.html",  // Swagger UI HTML
                                "/webjars/**"  // WebJars for Swagger UI
                        ).permitAll()
                        .anyRequest()
                        .authenticated()

        )

        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    
}
