package com.uab.taller.store.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo(){
        return new Info().title("Store service")
                .description("Creating my first API in order to offer online payment services")
                .version("0.0.1")
                .license( new License().name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact().name("Ing. Rodrigo Aspeti")
                        .email("rodrigo.aspeti@gmail.com")
                        .url("https://www.linkedin.com/in/rodrigoaspeti/")
                );
    }
}
