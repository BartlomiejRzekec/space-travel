package com.example.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.FlightDto;
import com.example.dto.TouristDto;
import com.example.entities.Flight;
import com.example.entities.Tourist;

@Transactional
public interface FlightDao {

	void saveFlight(Flight flight);
	
	List<FlightDto> findAllFlights();
	
	Flight findFlight(long id);
	
	void deleteFlight(Flight flight);
	
	void updateFlight(Flight flight);
	
	List<Flight> findFlight(LocalDateTime from, LocalDateTime to);
}
