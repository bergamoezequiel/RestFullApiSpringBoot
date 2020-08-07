package com.ezequiel.microwithSB.Usuarios;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.net.URI;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public List<User> GetAllUsers() {
		return service.findAll();
	} 
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> CreateUser( @RequestBody User user,BindingResult result) {
		
		service.addUser(user.getName(),user.getDni());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build(); //devuelve un 201 con el header Location
	} 
	
	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public EntityModel<User> GetUserById(@PathVariable Integer id) {
		User user = service.findOne(id);
		if (user!=null) {
			EntityModel<User> resource = EntityModel.of(user);
			
			/**HATEOAS links a otros recursos
			 * 
			 * {
   			     "id": 1,
   				"name": "ezequiel",
   				"dni": "37245432",
   				"_links": {"all-users": {"href": "http://localhost:8080/users"}}
                 }
			 * 
			 * 
			 */
			
			WebMvcLinkBuilder linkTo = 
					linkTo(methodOn(this.getClass()).GetAllUsers());
			
			resource.add(linkTo.withRel("all-users"));
			
			//HATEOAS
			
			return resource;
			
		}
		//va a ser manejada por CustomizedResponseEntityExceptionHandler
		throw new UserNotFoundException("no se encontro el ID") ;
	}
	
}
