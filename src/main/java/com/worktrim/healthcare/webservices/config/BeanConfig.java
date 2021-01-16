package com.worktrim.healthcare.webservices.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;
import java.util.Properties;


@Configuration
public class BeanConfig {

	 @Autowired
	 private Environment env;
	 

	 
	    @Bean
		public JavaMailSender getMailSender(){
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        
	        String smtpPort = env.getProperty("spring.mail.port");
	        String smtpHost = env.getProperty("spring.mail.host");     
	        String smtpUser = env.getProperty("spring.mail.username");  
	        String smtpPassword = env.getProperty("spring.mail.password");
	        
	        mailSender.setHost(smtpHost);
	        mailSender.setPort(Integer.parseInt(smtpPort));
	        mailSender.setUsername(smtpUser);
	        mailSender.setPassword(smtpPassword);
	         
	        
	        Properties javaMailProperties = new Properties();
	        javaMailProperties.put("mail.smtp.starttls.enable","true");
	        javaMailProperties.put("mail.smtp.auth","true");
	        javaMailProperties.put("mail.transport.protocol","smtp");
	        javaMailProperties.put("mail.debug","false");
	         
	        mailSender.setJavaMailProperties(javaMailProperties);
	         return mailSender;

		  }


		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}


		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource source = new ResourceBundleMessageSource();
			source.setBasenames("messages", "application", "application-dev", "application-prod");
			source.setDefaultEncoding("UTF-8");
			return source;

		}

		@Bean
		public LocaleResolver localeResolver() {
			CookieLocaleResolver cr = new CookieLocaleResolver();
			cr.setDefaultLocale(Locale.US);
			cr.setCookieName("localeInfo");

			cr.setCookieMaxAge(864000);//10 days
			return cr;



		}



}

