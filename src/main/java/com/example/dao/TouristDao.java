package com.example.dao;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Tourist;

public interface TouristDao {

	@Transactional
	void saveTourist(Tourist tourist);
	@Transactional
	void saveTourist(ApplicationReadyEvent event);
}
