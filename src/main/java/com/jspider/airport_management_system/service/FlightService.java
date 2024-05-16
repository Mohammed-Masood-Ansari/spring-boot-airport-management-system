package com.jspider.airport_management_system.service;

import java.util.List;

import com.jspider.airport_management_system.dto.Flight;
import com.jspider.airport_management_system.response.ApplicationResponse;

public interface FlightService {
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source, String destination);


}
