package com.example.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.dto.FlightDto;
import com.example.dto.TouristDto;
import com.example.entities.Flight;
import com.example.entities.Tourist;
import com.example.utilities.FlightsGenerator;

@Component
public class FlightDaoImpl implements FlightDao{

	private final SessionFactory sessionFactory;
	
	@Autowired
	public FlightDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void saveFlight(Flight flight) {
		sessionFactory.getCurrentSession().persist(flight);
	}
	
	@EventListener
	public void saveGeneratedFlights(ApplicationReadyEvent event) throws IOException, URISyntaxException {
		Random random = new Random();
		List<Tourist> tourists = FlightsGenerator.generateListOfTourists();
		int TouristsSize = random.nextInt(11);
		for(int i = 0; i < 1000; i++) {
			Flight flight = FlightsGenerator.generateFlight();
			for(int j = 0; j < TouristsSize; j++) {
				flight.addTourist(tourists.get(random.nextInt(tourists.size())));
			}
			TouristsSize = random.nextInt(11);
			sessionFactory.getCurrentSession().persist(flight);
		}
	}

	@Override
	public List<FlightDto> findAllFlights() {
		String hql = "Select new com.example.dto.FlightDto(f.id, f.departureDate, f.dateOfArrival, f.numberOfSeats, f.ticketPrice) FROM Flight f";
		Query<FlightDto> query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Flight findFlight(long id) {
		 return sessionFactory.getCurrentSession().get(Flight.class, id);
	}

	@Override
	public void deleteFlight(Flight flight) {
		sessionFactory.getCurrentSession().delete(flight);
	}

	@Override
	public void updateFlight(Flight flight) {
		sessionFactory.getCurrentSession().update(flight);
	}

	@Override
	public List<Flight> findFlight(LocalDateTime from, LocalDateTime to) {
		String hql = "Select f.id, f.departureDate, f.dateOfArrival FROM Flight f where f.departureDate between :from and :to";
		Query<Flight> query = sessionFactory.getCurrentSession().createQuery(hql)
																.setParameter("from", from)
																.setParameter("to", to);
		return query.list();
	}
}
