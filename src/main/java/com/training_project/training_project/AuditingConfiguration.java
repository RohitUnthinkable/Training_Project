package com.training_project.training_project;

import com.training_project.training_project.model.AuditorAwareImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImplementation();
    }
}
