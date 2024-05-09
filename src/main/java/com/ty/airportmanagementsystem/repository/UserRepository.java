package com.ty.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.airportmanagementsystem.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByUserEmail(String email);
}
