package com.ty.airportmanagementsystem.dao;

import com.ty.airportmanagementsystem.dto.Admin;

public interface AdminDao {
	public Admin fetchAdminByEmailForLoginDao(String email);
}
