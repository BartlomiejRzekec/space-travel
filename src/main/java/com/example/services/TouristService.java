package com.example.services;

import java.util.List;

import com.example.dto.TouristDto;
import com.example.entities.Tourist;

public interface TouristService {

	void saveTourist(Tourist tourist);
	
	List<TouristDto> findAllTourists();
	
	Tourist findTourist(long id);
	
	void deleteTourist(Tourist tourist);
	
	void updateTourist(Tourist tourist);
}
