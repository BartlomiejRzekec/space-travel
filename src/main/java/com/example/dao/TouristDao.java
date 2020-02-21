package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.TouristDto;
import com.example.entities.Tourist;

@Transactional
public interface TouristDao {

	void saveTourist(Tourist tourist);
	
	List<TouristDto> findAllTourists();
	
	Tourist findTourist(long id);
	
	void deleteTourist(Tourist tourist);
	
	void updateTourist(Tourist tourist);
}
