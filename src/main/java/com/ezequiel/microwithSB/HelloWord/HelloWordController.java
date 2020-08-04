package com.ezequiel.microwithSB.HelloWord;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	@RequestMapping(method = RequestMethod.GET, path = "/saludo")
	public String saludar() {
		return "Hola, buen dia";
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
