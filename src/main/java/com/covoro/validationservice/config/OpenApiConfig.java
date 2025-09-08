package com.covoro.validationservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Validation Service", contact = @Contact(name = "Prashant Bharti"), version = "0.0.1-SNAPSHOT"), servers = {
        @Server(description = "Local", url = "http://localhost:9000"),
        @Server(description = "QA", url = "http://testpeppol.gsthero.com"), }
)
public class OpenApiConfig {

}
