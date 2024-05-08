package com.ty.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.FlightDao;
import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.repository.FlightRepository;

@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	private FlightRepository flightRepository;
	
	@Override
	public Flight saveFlightDetailsDao(Flight flight) {
		return flightRepository.save(flight);
	}

}
