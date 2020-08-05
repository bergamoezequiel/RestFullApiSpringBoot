package com.ezequiel.microwithSB.Usuarios;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import com.ezequiel.microwithSB.HelloWord.SaludoBean;

@RestController
public class UserResource {
	@Autowired //no es neceario crear una instancia nueva del objeto cada vez que se necesite la funcionalidad de determinada clase 
	private UserDaoService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<User> saludarBean2Path() {
		return service.findAll();
	} 
	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public ResponseEntity<Object> saludarBean3Path(@RequestBody User user) {
		
		service.addUser(user.getName(),user.getDni());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); //devuelve un 201 con el header Location
	} 
	
}
