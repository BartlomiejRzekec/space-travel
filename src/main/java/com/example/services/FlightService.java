package com.example.services;

import java.time.LocalDateTime;
import java.util.List;


import com.example.dto.FlightDto;
import com.example.entities.Flight;

public interface FlightService {

	void saveFlight(Flight flight);
	
	List<FlightDto> findAllFlights();
	
	Flight findFlight(long id);
	
	void deleteFlight(Flight flight);
	
	void updateFlight(Flight flight);
	
	List<Flight> findFlight(LocalDateTime from, LocalDateTime to);
}
