package com.popper.fullstack.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.popper.fullstack.backend.service.EmailService;
import com.popper.fullstack.web.domain.frontend.FeedbackPojo;

@Controller
public class ContactController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

	/**The key which identifies the feedback payload in the Model**/
	public static final String FEEDBACK_MODEL_KEY = "feedback";
	
	/**The Contact Us view name*/
	private static final String CONTACT_US_VIEW_NAME = "contact/contact";
	
	@Autowired
	public EmailService emailService;
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactGet(ModelMap modelMap) {
		FeedbackPojo feedbackPojo = new FeedbackPojo();
		modelMap.addAttribute(ContactController.FEEDBACK_MODEL_KEY, feedbackPojo);
		return ContactController.CONTACT_US_VIEW_NAME;
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	public String contactPost(@ModelAttribute(FEEDBACK_MODEL_KEY) FeedbackPojo feedbackPojo) {
		LOG.debug("Feedback POJO content: {}", feedbackPojo);
		System.out.println(feedbackPojo);
		emailService.sendFeedbackEmail(feedbackPojo);
		return ContactController.CONTACT_US_VIEW_NAME;
	}
}
