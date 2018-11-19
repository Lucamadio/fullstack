package com.popper.fullstack.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.popper.fullstack.web.domain.frontend.FeedbackPojo;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.to.address}")
	private String defaultToAddress;
	
	protected SimpleMailMessage prepareSimpleMailMessageFromFeedbackPojo(FeedbackPojo feedback) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(defaultToAddress);
		message.setFrom(feedback.getEmail());
		message.setSubject("Feedback received from" + feedback.getFirstName() + " " + 
			feedback.getLastName()+"!");
		message.setText(feedback.getFeedBack());	
		return message;
	}

	@Override
	public void sendFeedbackEmail(FeedbackPojo feedbackPojo) {
		sendGenericEmailMessage(prepareSimpleMailMessageFromFeedbackPojo(feedbackPojo));
	}
	
	
}
