package com.jspider.airport_management_system.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.airport_management_system.dao.AdminDao;
import com.jspider.airport_management_system.dto.Admin;
import com.jspider.airport_management_system.repository.AdminRepository;

@Repository
public class AdminDaoImplementation implements AdminDao {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public Admin fetchAdminByEmailForLoginDao(String email) {
		return adminRepository.findByAdminEmail(email);
	}

}
