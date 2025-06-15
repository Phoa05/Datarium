package com.datarium.assets.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI datariumOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Assets Service API")
                        .description("API para gestão de ativos de investimento")
                        .version("v1.0"));
    }
}