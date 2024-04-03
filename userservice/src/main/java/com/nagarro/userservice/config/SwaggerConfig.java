package com.nagarro.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.nagarro.userservice.controller"))
                .build()
                .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails() {
        return new ApiInfo("USER CREATION AND VALIDATION API",
                "THIS API CREATE USER WITH NAME, EMAIL, CONTACT AND VALIDATES THE SAME",
                "1.0 V ",
                "FREE TO USE",
                new Contact("NAGARRO", "https://www.linkedin.com/company/nagarro/mycompany/", "marketing@nagarro.com"),
                "API LICENSE",
                "",
                Collections.emptyList());

    }

}
