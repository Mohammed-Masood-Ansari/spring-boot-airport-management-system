package com.jspider.airport_management_system.dao;

import java.util.List;

import com.jspider.airport_management_system.dto.Flight;

public interface FlightDao {

	public Flight saveFlightDetailsDao(Flight flight);
	
	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination);
}
