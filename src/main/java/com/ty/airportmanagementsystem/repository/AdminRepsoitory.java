package com.ty.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.airportmanagementsystem.dto.Admin;

public interface AdminRepsoitory extends JpaRepository<Admin, Integer>{

	public Admin findByAdminEmail(String email);
}
