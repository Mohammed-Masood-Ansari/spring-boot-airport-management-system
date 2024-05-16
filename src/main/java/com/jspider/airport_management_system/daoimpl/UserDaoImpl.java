package com.jspider.airport_management_system.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.airport_management_system.dao.UserDao;
import com.jspider.airport_management_system.dto.User;
import com.jspider.airport_management_system.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;

	@Override
	public User userRegisterDao(User user) {
		return repository.save(user);
	}

	@Override
	public User fetchUserByEmailForLoginDaos(String email) {
		return repository.findByUserEmail(email);
	}
}