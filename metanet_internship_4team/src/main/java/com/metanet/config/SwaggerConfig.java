package com.metanet.config;
import springfox.documentation.builders.RequestHandlerSelectors;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
    public Docket swaggerApi(){
        return new Docket(DocumentationType.SWAGGER_2).ignoredParameterTypes(ApiIgnore.class)
                .apiInfo(swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.metanet.controller"))
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("API Documentation")
                .title("Metanet InterShip 4Team")
                .description("요리하는주웅 문서 ")
                .build();
    }

}

