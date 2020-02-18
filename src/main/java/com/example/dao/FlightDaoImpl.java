package com.example.dao;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.entities.Flight;
import com.example.entities.Tourist;
import com.example.utilities.FlightsGenerator;

@Component
public class FlightDaoImpl implements FlightDao{

	private SessionFactory sessionFactory;
	
	
	@Autowired
	public FlightDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@EventListener
	public void saveGeneratedFlights(ApplicationReadyEvent event) throws IOException, URISyntaxException {
		
		List<Tourist> tourists = FlightsGenerator.generateListOfTourists();
		System.out.println(tourists);
		int size = (int) Math.random() * 10;
		for(int i = 0; i < 1000; i++) {
			Flight flight = FlightsGenerator.generateFlight();
			for(int j = 0; j < size; j++) {
				flight.addTourist(tourists.get((int) Math.random() * tourists.size()));
			}
		
			sessionFactory.getCurrentSession().persist(flight);
		}
		
//			sessionFactory.getCurrentSession().persist(flight);
	}

	@Override
	public void saveFlight(Flight flight) {
		// TODO Auto-generated method stub
		
	}
}
