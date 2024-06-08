package com.progresssoft.deals.configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    @Bean
    public OpenAPI dealsDataWarehouseOpenAPI() {

        return new OpenAPI()
                .info(new Info().title("Deals Data Warehouse").description("Deals Data Warehouse").version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation().description("Deals Data Warehouse Documentation"));
    }

    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder().group("API V3").pathsToMatch("/**").build();
    }


}