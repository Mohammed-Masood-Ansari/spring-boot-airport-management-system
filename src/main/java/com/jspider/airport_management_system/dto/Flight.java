package com.jspider.airport_management_system.dto;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	@Column(name = "number")
	private String flightNumber;
	@Column(name = "name")
	private String flightName;
	@Column(name = "source")
	private String flightSource;
	@Column(name = "destintion")
	private String flightDestination;
	@Column(name = "status")
	private String flightStatus;
	@Column(name = "arrivaltime")
	private LocalTime flightArrivalTime;
	@Column(name = "departuretime")
	private LocalTime flightDepatureTime;
	@Column(name = "duration")
	private String flightDuration;
	@Column(name = "price")
	private double flightPrice;
	@Column(name = "seats")
	private int flightNumberOfSeats;
}
