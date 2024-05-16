package com.jspider.airport_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.airport_management_system.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByAdminEmail(String email);
}
