package com.ty.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.airportmanagementsystem.dao.AdminDao;
import com.ty.airportmanagementsystem.dto.Admin;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ApplicationResponse<Admin> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<Admin> fetchAdminByEmailForLoginService(String email,String password) {
		Admin admin=adminDao.fetchAdminByEmailForLoginDao(email);
		
		if(admin!=null) {
			
			if(admin.getAdminPassword().equals(password)) {
				httpSession.setAttribute("admin", admin.getAdminEmail());
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("admin logged in successfully....");
				applicationResponse.setDescription("admin logged in and session is created with email id...");
				admin.setAdminPassword("***************");
				applicationResponse.setData(admin);
				return applicationResponse;
			}else {
				applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponse.setMessage("password is incorrect");
				applicationResponse.setDescription("please pass correct password and check once");
				applicationResponse.setData(null);
				return applicationResponse;
			}
			
		}else {
			applicationResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
			applicationResponse.setMessage("email is incorrect");
			applicationResponse.setDescription("please pass correct email id and check once");
			applicationResponse.setData(null);
			return applicationResponse;
		}
	}

}
