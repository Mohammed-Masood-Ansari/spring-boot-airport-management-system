package com.ty.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.airportmanagementsystem.dao.UserDao;
import com.ty.airportmanagementsystem.dto.User;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.UserService;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private ApplicationResponse<User> aResponse;
	
	@Autowired
	private UserDao dao;
 	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<User> userRegisterService(User user) {
		
		User user2=dao.userRegisterDao(user);
		
		if(user2!=null) {
			aResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			aResponse.setMessage("User---Registered---SuccessFully");
			aResponse.setDescription("u can follow below data what is addedd inside table");
			aResponse.setData(user2);
			return aResponse;
		}else {
			aResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			aResponse.setMessage("User---NOT----Registered");
			aResponse.setDescription("check sql query or database");
			aResponse.setData(null);
			return aResponse;
		}
		
	}

	@Override
	public ApplicationResponse<User> fetchUserByEmailForLoginService(String email, String password) {
		
		User user = dao.fetchUserByEmailForLoginDaos(email);
		
		if(user!=null) {
			
			if(user.getUserPassword().equals(password)) {
				httpSession.setAttribute("userSession", email);
				aResponse.setStatusCode(HttpStatus.FOUND.value());
				aResponse.setMessage("User---Logged--In---SuccessFully");
				aResponse.setDescription("User session is created ");
				aResponse.setData(user);
				return aResponse;
			}else {
				aResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				aResponse.setMessage("User---Registered---SuccessFully");
				aResponse.setDescription("u can follow below data what is addedd inside table");
				aResponse.setData(user);
				return aResponse;
			}
			
		}else {
			aResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			aResponse.setMessage("User---Registered---SuccessFully");
			aResponse.setDescription("u can follow below data what is addedd inside table");
			aResponse.setData(null);
			return aResponse;
		}
	}

}
