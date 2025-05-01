package com.example.spring_security_service_01.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Integer,User> {
    Optional<User> findByEmail(String email);
}
