package com.ty.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.airportmanagementsystem.dao.FlightDao;
import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.FlightService;

import jakarta.servlet.http.HttpSession;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private ApplicationResponse<Flight> applicationResponse;
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight) {
		
		if(httpSession.getAttribute("admin")!=null) {
			Flight flight1=flightDao.saveFlightDetailsDao(flight);
			if(flight1!=null) {
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("Flight---Details---Addedd");
				applicationResponse.setDescription("u can follow below data what is addedd inside table");
				applicationResponse.setData(flight1);
				return applicationResponse;
			}else {
				applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				applicationResponse.setMessage("You are logged in with admin");
				applicationResponse.setDescription("But there might be problem with database or json please check once");
				applicationResponse.setData(null);
				return applicationResponse;
			}
		}else {
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("You are not logged in with admin");
			applicationResponse.setDescription("please logged in with admin and then add flight details....");
			applicationResponse.setData(null);
			return applicationResponse;
		}
	}

}
