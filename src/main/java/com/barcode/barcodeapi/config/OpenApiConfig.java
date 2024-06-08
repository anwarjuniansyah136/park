package com.barcode.barcodeapi.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI myOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8081");
        localServer.setDescription("Server url in local environment");

        Contact contact = new Contact();
        contact.setEmail("test@gmail.com");
        contact.setName("https://www.test.com");

        License mitLicense = new License().name("MIT License").url("https://test.com");

        Info info = new Info().title("Dapa Electronic Store")
                .version("1.0").contact(contact).description("This API is for final project of java course from group one.")
                .termsOfService("http://www.test.com/terms").license(mitLicense);
        return new OpenAPI().info(info).servers(List.of(localServer));
    }
}
