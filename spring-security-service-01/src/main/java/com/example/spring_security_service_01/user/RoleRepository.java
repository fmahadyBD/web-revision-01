package com.example.spring_security_service_01.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Integer,Role>{
    
    Optional<Role> findByName(String name);
}
