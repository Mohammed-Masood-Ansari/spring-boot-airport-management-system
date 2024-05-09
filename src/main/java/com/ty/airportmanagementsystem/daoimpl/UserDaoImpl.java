package com.ty.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.UserDao;
import com.ty.airportmanagementsystem.dto.User;
import com.ty.airportmanagementsystem.repository.UserRepository;

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
