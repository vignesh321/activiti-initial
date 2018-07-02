package com.bpmn.controllers;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/users")
public class UsersController {

	@Autowired
	IdentityService identityService;
	
	/*@GetMapping (value = "/getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUsers(){
		
		System.out.println("Inside getAll Users");
		return identityService.createUserQuery().list();
	}*/
	
	@PostMapping (value = "/addUser" , consumes = {"application/json"})
	public void addUser(@RequestBody final User user) {
		
		System.out.println("First Name : " + user.getFirstName());
		System.out.println("Last Name : " + user.getLastName());
		System.out.println("Inside save user");
		//identityService.saveUser(user);
		//return null;
	}
	
}
