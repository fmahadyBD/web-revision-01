package com.example.spring_security_service_01.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.spring_security_service_01.model.User;


/*
 * ApplicationAuditAware provides the current logged-in user's ID to automatically fill auditing fields like createdBy and modifiedBy in your database entities.

It works with Spring Data JPA auditing to track who created or updated a record.
 */


public class ApplicationAuditAware implements AuditorAware<Integer> {

    @Override
    public Optional<Integer> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null ||
                !authentication.isAuthenticated() ||
                authentication instanceof AnonymousAuthenticationToken

        ) {
            return Optional.empty();
        }

        User userPrincipal = (User) authentication.getPrincipal();

        return Optional.ofNullable(
                (userPrincipal.getId()));
    }

}
