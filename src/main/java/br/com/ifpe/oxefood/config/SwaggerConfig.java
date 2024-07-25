package br.com.ifpe.oxefood.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("OxeFood API")
                        .version("1.0")
                        .description("API do OxeFood")
                        .contact(new Contact()
                                .name("Aluno IFPE")
                                .email("aluno@discente.ifpe.edu.br")));
    }

    @Bean
    public GroupedOpenApi customApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**")
                .pathsToExclude("/error", "/actuator/**")
                .build();
    }
}
