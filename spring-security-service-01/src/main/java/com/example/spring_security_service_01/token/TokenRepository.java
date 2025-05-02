package com.example.spring_security_service_01.token;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token,Integer> {
    
    Optional<Token> findByToken(String token);
}
