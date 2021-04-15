package com.inmajimenez.proyectoFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Clase de swagger para documentación con url:
 * http://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket swaggerConfiguration(){
        return
                new Docket(DocumentationType.SWAGGER_2)
                        .select()
                        .apis(RequestHandlerSelectors.basePackage("com.inmajimenez.proyectoFinal"))
                        .build().apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("API Proyecto Final",
                "Aplicación con Spring Boot",
                "1.0",
                "",
                new Contact("Inmaculada Jiménez", "","inmalmeda@hotmail.com"),
                "",
                "",
                Collections.emptyList());
    }
}
