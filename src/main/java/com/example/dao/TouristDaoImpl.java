package com.example.dao;

import java.io.IOException;
import java.net.URISyntaxException;


import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Tourist;
import com.example.utilities.FlightsGenerator;

@Component
public class TouristDaoImpl implements TouristDao {
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public TouristDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
//	@EventListener
	public void saveTourist(ApplicationReadyEvent event) {
		try {
			sessionFactory.getCurrentSession().persist(FlightsGenerator.generateTourist());
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void saveTourist(Tourist tourist) {
		sessionFactory.getCurrentSession().persist(tourist);
	}
	

}
