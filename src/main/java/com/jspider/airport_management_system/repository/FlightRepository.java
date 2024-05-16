package com.jspider.airport_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.airport_management_system.dto.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
