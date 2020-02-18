package com.example.dao;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Flight;

public interface FlightDao {

	@Transactional
	void saveGeneratedFlights(ApplicationReadyEvent event) throws IOException, URISyntaxException;
	
	@Transactional
	void saveFlight(Flight flight);
}
