package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TouristDao;
import com.example.entities.Tourist;

@Service
public class TouristServiceImpl implements TouristService {

	private TouristDao touristDao;

	
	
	@Autowired
	public TouristServiceImpl(TouristDao touristDao) {
		super();
		this.touristDao = touristDao;
	}



	@Override
	public void saveTourist(Tourist tourist) {
		touristDao.saveTourist(tourist);
	} 



	
	
	
	
}
