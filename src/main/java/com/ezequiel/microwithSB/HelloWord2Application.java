package com.ezequiel.microwithSB;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@SpringBootApplication
public class HelloWord2Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HelloWord2Application.class,args);
	}
	

	/*De donde se van a tomar los mensajes 
	 * In the Application, we create a bean, call its method and set up the Spring Boot application. 
	 * The CommandLineRunner interface indicates that a bean should run 
	 * when it is contained within a SpringApplication. 
	 * It can be used to create command line applications in Spring Boot.
	 * 
	 * The @SpringBootApplication annotation enables auto-configuration and component scanning.
	 * With the @Autowired annotation we inject our AppName bean into the field
	 */
	@Bean 
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");//toma de messages_*.properties
		return messageSource;
	}

}
