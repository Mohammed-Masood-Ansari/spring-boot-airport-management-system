package com.jspider.airport_management_system.service;

import com.jspider.airport_management_system.dto.User;
import com.jspider.airport_management_system.response.ApplicationResponse;

public interface UserService {

	public ApplicationResponse<User> userRegisterService(User user); 
	
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email,String password);
}