package com.popper.fullstack.backend.service;

import org.springframework.mail.SimpleMailMessage;

import com.popper.fullstack.web.domain.frontend.FeedbackPojo;

public interface EmailService {
	
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo);

	public void sendGenericEmailMessage(SimpleMailMessage message);

}
