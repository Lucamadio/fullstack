package com.popper.fullstack.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.popper.fullstack.backend.service.EmailService;
import com.popper.fullstack.backend.service.MockEmailService;

@Configuration
@Profile("dev")
@PropertySource("file:///${user.home}/IdeaProjects/application-dev.properties")
public class DevelopmentConfig {

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	@Bean
	public ServletRegistrationBean h2ConsoleServletRegistration() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(new WebServlet());
	    bean.addUrlMappings("/console/*");
	    return bean;
	}
}
