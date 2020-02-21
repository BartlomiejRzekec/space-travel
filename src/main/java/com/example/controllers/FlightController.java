package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Flight;
import com.example.services.FlightService;
import com.example.services.ServiceResponse;

@RestController
public class FlightController {

	private final FlightService flightService;

	@Autowired
	public FlightController(FlightService flightService) {
		this.flightService = flightService;
	}

	@PostMapping("/saveFlight")
	public ResponseEntity<Object> saveFlight(@RequestBody Flight flight){
		flightService.saveFlight(flight);
		ServiceResponse<Flight> response = new ServiceResponse<Flight>("success", flight);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
