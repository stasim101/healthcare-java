package com.worktrim.healthcare.webservices.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


@Service("localeMessageLoader")
public class LoadMessageForLocale {
	
	@Autowired
	MessageSource messageSource;
	
	
	
	/**
	 * 
	 * @param msgString The target message string
	 * @param msgArgs Any arguments to be parsed to resource bundle or properties file
	 * @return String --> The target message from the resource bundle or property file translated to the current locale context
	 */
	public String getMessage(String msgString, Object[] msgArgs ) {
		
     	 //Locale locale = LocaleContextHolder.getLocale();

    	 String msg = messageSource.getMessage(msgString, msgArgs, null);
		
	  return msg;	
		
	}
	
	
	

}
