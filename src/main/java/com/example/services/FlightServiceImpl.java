package com.example.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FlightDao;
import com.example.dto.FlightDto;
import com.example.entities.Flight;

@Service
public class FlightServiceImpl implements FlightService {

	private final FlightDao flightDao;
	
	@Autowired
	public FlightServiceImpl(FlightDao flightDao) {
		this.flightDao = flightDao;
	}

	@Override
	public void saveFlight(Flight flight) {
		flightDao.saveFlight(flight);
	}

	@Override
	public List<FlightDto> findAllFlights() {
		return flightDao.findAllFlights();
	}

	@Override
	public Flight findFlight(long id) {
		return flightDao.findFlight(id);
	}

	@Override
	public void deleteFlight(Flight flight) {
		flightDao.deleteFlight(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		flightDao.updateFlight(flight);
	}

	@Override
	public List<Flight> findFlight(LocalDateTime from, LocalDateTime to) {
		return flightDao.findFlight(from, to);
	}
}
