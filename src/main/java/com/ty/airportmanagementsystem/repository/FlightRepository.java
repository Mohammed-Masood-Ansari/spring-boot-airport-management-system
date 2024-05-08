package com.ty.airportmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.airportmanagementsystem.dto.Flight;

public interface FlightRepository extends JpaRepository<Flight, String> {

}
