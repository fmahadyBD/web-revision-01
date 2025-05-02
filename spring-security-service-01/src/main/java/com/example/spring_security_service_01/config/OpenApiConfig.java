package com.example.spring_security_service_01.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(contact = @Contact(name = "fahim", email = "fahadybd@gmail.com", url = "https://.co"

), description = "OpenApi documentation for spring secuurity", title = "OpenApi specification", version = "1.0", license = @License(name = "lincenc name", url = "https://some-url.comm"), termsOfService = "terms of service"

), servers = {
        @Server(description = "Local ENV", url = "http://localhost:8088/api/v1"),
        @Server(description = "PROD ENV", url = "https://dd.com/co"

        )
}, security = {
        @SecurityRequirement(name = "bearerAuth")
})

@SecurityScheme(name = "bearerAuth", description = "JWT ath description", scheme = "bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", in = SecuritySchemeIn.HEADER)
public class OpenApiConfig {

}
