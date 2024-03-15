package com.example.edulightbe.core;

import com.example.edulightbe.entities.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class EduLightJpaConfig {
    @Bean
    public AuditorAware<Account> auditorProvider() {
        return new EduLightAuditorAware();
    }
}
