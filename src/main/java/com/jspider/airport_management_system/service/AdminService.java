package com.jspider.airport_management_system.service;

import com.jspider.airport_management_system.dto.Admin;
import com.jspider.airport_management_system.response.ApplicationResponse;

public interface AdminService {
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email , String password);

}
