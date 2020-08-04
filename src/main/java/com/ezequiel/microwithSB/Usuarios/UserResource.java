package com.ezequiel.microwithSB.Usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.ezequiel.microwithSB.HelloWord.SaludoBean;

@RestController
public class UserResource {
	@Autowired //no es neceario crear una instancia nueva del objeto cada vez que se necesite la funcionalidad de determinada clase 
	private UserDaoService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> saludarBean2Path() {
		return service.findAll();
	} 
	@RequestMapping(method = RequestMethod.GET, path = "/users/nuevo")
	public String saludarBean3Path() {
		
		service.addUser();
		return "ok";
	} 
	
}
