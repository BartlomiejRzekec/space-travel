package com.example.services;

import org.springframework.stereotype.Service;

import com.example.entities.Flight;

@Service
public interface FlightService {

	void saveGeneratedFlights();
	
	void saveFlight(Flight flight);
}
