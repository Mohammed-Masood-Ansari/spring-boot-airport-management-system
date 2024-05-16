package com.jspider.airport_management_system.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jspider.airport_management_system.dao.FlightDao;
import com.jspider.airport_management_system.dto.Flight;
import com.jspider.airport_management_system.response.ApplicationResponse;
import com.jspider.airport_management_system.service.FlightService;

import jakarta.servlet.http.HttpSession;

@Service
public class FlightServiceImplementation implements FlightService {

	@Autowired
	private FlightDao flightDao;

	@Autowired
	private ApplicationResponse<Flight> applicationResponse;

	@Autowired
	private ApplicationResponse<List<Flight>> applicationResponseList;

	@Autowired
	private HttpSession httpSession;

	@Override
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight) {

		if (httpSession.getAttribute("admin") != null) {

			Flight flight1 = flightDao.saveFlightDetailsDao(flight);
			if (flight1 != null) {
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("Flight--Details--Successfully--Added");
				applicationResponse.setDescription("You Can Now Retrieve The Data");
				applicationResponse.setData(flight1);
			} else {
				applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				applicationResponse.setMessage("You Are Logged-In As Admin");
				applicationResponse.setDescription("There Is A Problem In DataBase OR JSon");
				applicationResponse.setData(null);
				return applicationResponse;
			}
		} else {
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("Yor Are Not Logged-In");
			applicationResponse.setDescription("Login With Admin And Then Add Details");
			applicationResponse.setData(null);
			return applicationResponse;
		}
		return null;
	}

	@Override
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source,
			String destination) {
		List<Flight> flights = flightDao.getFlightWithSourceAndDestinationDao(source, destination);
		if (httpSession.getAttribute("userSession") != null) {

			if (!flights.isEmpty()) {
				applicationResponseList.setStatusCode(HttpStatus.FOUND.value());
				applicationResponseList.setMessage(source + " to " + destination);
				applicationResponseList.setDescription("Given Soure And Destination Are....");
				applicationResponseList.setData(flights);
				return applicationResponseList;
			} else {

				applicationResponseList.setStatusCode(HttpStatus.NOT_FOUND.value());
				applicationResponseList.setMessage("Invalid Destination");
				applicationResponseList.setDescription("There are no flights with the given destination or source");
				applicationResponseList.setData(null);
				return applicationResponseList;
			}
		} else {
			applicationResponseList.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponseList.setMessage("Yor Are Not Logged-In");
			applicationResponseList.setDescription("Login With User And Then Search For Details");
			applicationResponseList.setData(null);
			return applicationResponseList;
		}
	}

}
