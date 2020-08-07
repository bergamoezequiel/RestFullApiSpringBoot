package com.ezequiel.microwithSB.HelloWord;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/saludo")
	public String saludar2() {
		return "Hola, buen dia";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/saludo-internacional")
	public String saludar() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		
	/*
	 * 	LocaleContextHolder.getLocale() Saca lengua de header Accept-Language
	 * 
	 * 
	 * 
	 */
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/saludo-bean")
	public SaludoBean saludarBean() {
		//al cliente le llega un Json representando al Bean
		return new SaludoBean("Hola, soy un bean");
	} 
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/saludo-bean/{name}/{otro}")
	public SaludoBean saludarBeanPath(@PathVariable String name,@PathVariable String otro ) {
		//al cliente le llega un Json representando al Bean
		return new SaludoBean(name+"+"+otro);
	} 
	
	
}
