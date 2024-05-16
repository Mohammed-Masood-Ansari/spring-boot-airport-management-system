package com.jspider.airport_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.airport_management_system.dto.Admin;
import com.jspider.airport_management_system.response.ApplicationResponse;
import com.jspider.airport_management_system.service.AdminService;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping(value = "/loginAdmin/{email}/{password}")
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(@PathVariable String email,@PathVariable String password) {
		return adminService.fetchAdminByEmailForLoginService(email, password);
	
	}
}
