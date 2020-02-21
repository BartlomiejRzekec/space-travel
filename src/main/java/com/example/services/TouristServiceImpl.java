package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TouristDao;
import com.example.dto.TouristDto;
import com.example.entities.Tourist;

@Service
public class TouristServiceImpl implements TouristService {

	private final TouristDao touristDao;

	@Autowired
	public TouristServiceImpl(TouristDao touristDao) {
		this.touristDao = touristDao;
	}

	@Override
	public void saveTourist(Tourist tourist) {
		touristDao.saveTourist(tourist);
	}

	@Override
	public List<TouristDto> findAllTourists() {
		return touristDao.findAllTourists();
	}

	@Override
	public Tourist findTourist(long id) {
		return touristDao.findTourist(id);
	}

	@Override
	public void deleteTourist(Tourist tourist) {
		touristDao.deleteTourist(tourist);
	}

	@Override
	public void updateTourist(Tourist tourist) {
		touristDao.updateTourist(tourist);
	}
}
