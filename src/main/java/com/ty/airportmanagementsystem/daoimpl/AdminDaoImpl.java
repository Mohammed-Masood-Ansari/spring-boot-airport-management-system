package com.ty.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.AdminDao;
import com.ty.airportmanagementsystem.dto.Admin;
import com.ty.airportmanagementsystem.repository.AdminRepsoitory;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private AdminRepsoitory adminRepsoitory;
	
	@Override
	public Admin fetchAdminByEmailForLoginDao(String email) {
		return adminRepsoitory.findByAdminEmail(email);
	}

	
}
