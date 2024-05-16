package com.jspider.airport_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.airport_management_system.dto.User;
import com.jspider.airport_management_system.response.ApplicationResponse;
import com.jspider.airport_management_system.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/userRegister")
	public ApplicationResponse<User> UserRegisterController(@RequestBody User user){
		return userService.userRegisterService(user);
	}
	
	@GetMapping(value = "/loginUser/{email}/{password}")
	public ApplicationResponse<User> fetchUserByEmailForLogin(@PathVariable String email,@PathVariable String password) {
		return userService.fetchUserByEmailForLoginService(email, password);
	
	}
}
