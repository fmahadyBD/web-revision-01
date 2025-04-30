package com.example.spring_security_service_01.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Integer,Role>{
    
}
