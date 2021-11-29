package com.training_project.training_project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    public static final Contact CONTACT = new Contact("Rohit", "http://rohitsharma.in","rohit.sharma@unthinkable.co");

    @Bean
    public Docket newApi() {
        Set produce = new HashSet<>(Arrays.asList("application/json","application/xml"));
        Set consume = new HashSet<>(Arrays.asList("application/json", "application/xml"));

        return new Docket(DocumentationType.SWAGGER_2)
                .produces(produce)
                .consumes(consume)
                .apiInfo(getApiInfo());
    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Training Project Services")
                .description("Training Project Services provide by Employee and Department APIs")
                .termsOfServiceUrl("urn:tos")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .license("Apache License")
                .version("1.0")
                .contact(CONTACT)
                .build();
    }
}
