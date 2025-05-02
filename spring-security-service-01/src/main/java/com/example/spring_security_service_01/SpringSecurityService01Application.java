package com.example.spring_security_service_01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.spring_security_service_01.user.Role;
import com.example.spring_security_service_01.user.RoleRepository;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
@SpringBootApplication
public class SpringSecurityService01Application {


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityService01Application.class, args);
	}

	@Bean
public CommandLineRunner runner(RoleRepository roleRepository){
	return args ->{
		if(roleRepository.findByName("USER").isEmpty()){
			roleRepository.save(Role.builder().name("USER").build());
		}
	};
}

}
