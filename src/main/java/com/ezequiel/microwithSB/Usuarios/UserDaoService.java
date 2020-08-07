package com.ezequiel.microwithSB.Usuarios;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	
	private static Integer maxId=2;
	
	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(1,"ezequiel","37245432"));
		users.add(new User(2,"pamela","33212322"));
	}
	
	public List<User> findAll(){
		return users;
	}
	public User findOne(Integer id) {
		for(User user:users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	public void addUser(String name,String dni) {
		maxId+=1;
		users.add(new User(maxId,name,dni));
	}
	
}
