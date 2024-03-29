package br.com.llduran.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@SecurityScheme(
		name = "Bearer Auth",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class OpenApiConfig
{
	@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI().info(new Info().title("RESTful API with Java 18 and Spring Boot 3").version("v1")
				.description("REST API's RESTFul do 0 à AWS com Java 18, Spring Boot 3.x e Docker").termsOfService("https://github.com/LindineuDuran?tab=repositories")
				.license(new License().name("Apache 2.0").url("https://github.com/LindineuDuran?tab=repositories")));
	}
}