package com.popper.fullstack.web.i18n;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class I18NService {

	private MessageSource messageSource;
	
	/**
	 * Return a message for the given message id and the default locale
	 * in the session context
	 * @param messageId The key to hte messages resource file
	 * **/
	public String getMessage(String messageId){
		Locale locale = LocaleContextHolder.getLocale();
		return getMessage(messageId, locale);
	}

	/**
	 * Return a message for the given message id and the default locale
	 * in the session context
	 * @param messageId The key to hte messages resource file
	 * @param locale The localeS
	 * **/
	private String getMessage(String messageId, Locale locale) {
		return messageSource.getMessage(messageId,  null, locale);
	}
	
}
