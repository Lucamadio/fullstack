package com.popper.fullstack.web.i18n;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class I18NService {

	private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);
	
	private MessageSource messageSource;
	
	/**
	 * Return a message for the given message id and the default locale
	 * in the session context
	 * @param messageId The key to the messages resource file
	 * **/
	public String getMessage(String messageId){
		LOG.info("Returning i18n text for messageId: {})", messageId);
		Locale locale = LocaleContextHolder.getLocale();
		return getMessage(messageId, locale);
	}

	/**
	 * Return a message for the given message id and the default locale
	 * in the session context
	 * @param messageId The key to the messages resource file
	 * @param locale The localeS
	 * **/
	private String getMessage(String messageId, Locale locale) {
		return messageSource.getMessage(messageId,  null, locale);
	}
	
}
