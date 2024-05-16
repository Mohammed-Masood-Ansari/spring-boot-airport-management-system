package com.jspider.airport_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.airport_management_system.dto.Admin;
import com.jspider.airport_management_system.dto.Flight;
import com.jspider.airport_management_system.response.ApplicationResponse;
import com.jspider.airport_management_system.service.AdminService;
import com.jspider.airport_management_system.service.FlightService;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@PostMapping(value = "/saveFlightDetails")
	public ApplicationResponse<Flight> saveFlightDetailsController(@RequestBody Flight flight) {
	
		return flightService.saveFlightDetailsService(flight);
	}
	@GetMapping(value = "getFlightWithSourceAndDestinationService/{source}/{destination}")
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(@PathVariable String source,
			@PathVariable String destination) {
		return flightService.getFlightWithSourceAndDestinationService(source, destination);
	}
}
