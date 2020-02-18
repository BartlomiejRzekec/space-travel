package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FlightDao;
import com.example.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	private FlightDao flightDao;
	
	
	@Autowired
	public FlightServiceImpl(FlightDao flightDao) {
		this.flightDao = flightDao;
	}



	@Override
	public void saveGeneratedFlights() {
	}



	@Override
	public void saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}

}
