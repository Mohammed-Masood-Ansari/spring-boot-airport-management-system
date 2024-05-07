package com.ty.airportmanagementsystem.service;

import com.ty.airportmanagementsystem.dto.Admin;
import com.ty.airportmanagementsystem.response.ApplicationResponse;

public interface AdminService {
	
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email,String password);
}
