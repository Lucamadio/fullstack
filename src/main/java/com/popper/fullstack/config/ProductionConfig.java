package com.popper.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.popper.fullstack.backend.service.EmailService;
import com.popper.fullstack.backend.service.SmtpEmailService;

@Configuration
@Profile("prod")
@PropertySource("file:///${user.home}/IdeaProjects/application-prod.properties")
public class ProductionConfig { 
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
}
