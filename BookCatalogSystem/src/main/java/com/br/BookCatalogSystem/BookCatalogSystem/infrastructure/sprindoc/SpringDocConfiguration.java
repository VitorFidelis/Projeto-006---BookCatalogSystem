package com.br.BookCatalogSystem.BookCatalogSystem.infrastructure.sprindoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfiguration {
    @Value("${spring.springdoc.swagger.api.v1.title}")
    private String title;

    @Value("${spring.springdoc.swagger.api.v1.description}")
    private String description;

    @Value("${spring.springdoc.swagger.api.v1.version}")
    private String version;

    @Value("${spring.springdoc.swagger.api.v1.contactname}")
    private String contacName;

    @Value("${spring.springdoc.swagger.api.v1.contactemail}")
    private String contacEmail;

    @Value("${spring.springdoc.swagger.api.v1.licensename}")
    private String licenseName;

    @Value("${spring.springdoc.swagger.api.v1.licenseurl}")
    private String licenseUrl;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(new Contact()
                                .name(contacName)
                                .email(contacEmail)
                        )
                        .license(new License()
                                .name(licenseName)
                                .url(licenseUrl)
                        )
                );
    }
}
