package com.jspider.airport_management_system.dao;

import com.jspider.airport_management_system.dto.Admin;

public interface AdminDao {

	public Admin fetchAdminByEmailForLoginDao(String email);
}
