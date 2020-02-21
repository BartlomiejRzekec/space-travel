package com.example.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.TouristDto;
import com.example.entities.Tourist;

@Component
public class TouristDaoImpl implements TouristDao {
	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public TouristDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveTourist(Tourist tourist) {
		sessionFactory.getCurrentSession().save(tourist);
	}

	@Override
	public List<TouristDto> findAllTourists() {
		String hql = "Select new com.example.dto.TouristDto(t.id, t.firstName, t.lastName, t.gender, t.country, t.birthDate) FROM Tourist t";
		Query<TouristDto> query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public Tourist findTourist(long id) {
		return sessionFactory.getCurrentSession().get(Tourist.class, id);
	}

	@Override
	public void deleteTourist(Tourist tourist) {
		sessionFactory.getCurrentSession().delete(tourist);
	}

	@Override
	public void updateTourist(Tourist tourist) {
		sessionFactory.getCurrentSession().update(tourist);
	}
}
