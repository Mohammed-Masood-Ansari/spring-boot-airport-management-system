package com.ty.airportmanagementsystem.service;

import com.ty.airportmanagementsystem.dto.User;
import com.ty.airportmanagementsystem.response.ApplicationResponse;


public interface UserService {

	public ApplicationResponse<User> userRegisterService(User user); 
	
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email,String password);
}
