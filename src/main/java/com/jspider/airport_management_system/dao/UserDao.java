package com.jspider.airport_management_system.dao;

import com.jspider.airport_management_system.dto.User;

public interface UserDao {

	public User userRegisterDao(User user); 
	public User fetchUserByEmailForLoginDaos(String email);

}
