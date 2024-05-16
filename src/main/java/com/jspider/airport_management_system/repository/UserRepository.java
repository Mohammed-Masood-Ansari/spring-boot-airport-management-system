package com.jspider.airport_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.airport_management_system.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

	public User findByUserEmail(String email);

}
