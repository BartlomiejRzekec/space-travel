package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Tourist;
import com.example.services.ServiceResponse;
import com.example.services.TouristService;

@RestController
public class TouristController {

	
	private TouristService touristService;

	@Autowired
	public TouristController(TouristService touristService) {
		this.touristService = touristService;
	}
	
	@PostMapping("/saveTourist")
	public ResponseEntity<Object> saveTourist(@RequestBody Tourist tourist){
		touristService.saveTourist(tourist);
		ServiceResponse<Tourist> response = new ServiceResponse<Tourist>("success", tourist);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
}
