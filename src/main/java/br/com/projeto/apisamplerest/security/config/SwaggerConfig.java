package br.com.projeto.apisamplerest.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("application")
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.gov.ce.seduc.apipronatec.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
    
    @Bean
    public Docket apiSecurity(){
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("security")
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.gov.ce.seduc.apipronatec.security.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("")
                .description("Api do Sistema Pronatec")
                .version("1.0")
                .build();
    }
      
}