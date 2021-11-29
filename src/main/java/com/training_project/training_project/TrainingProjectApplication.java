package com.training_project.training_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
public class TrainingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingProjectApplication.class, args);
	}

}