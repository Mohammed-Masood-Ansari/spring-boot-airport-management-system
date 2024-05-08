package com.ty.airportmanagementsystem.service;

import com.ty.airportmanagementsystem.dto.Flight;
import com.ty.airportmanagementsystem.response.ApplicationResponse;

public interface FlightService {

	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);
}
