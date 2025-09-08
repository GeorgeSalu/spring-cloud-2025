package br.com.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "Exchange Microservice Api",
                version = "V1",
                description = "Documentation of exchange microservice api"
        )
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI cusOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Exchange Microservice Api")
                        .version("V1")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("http://localhost:8100/exchange-service")
                        )
                );
    }

}
