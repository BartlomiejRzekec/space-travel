package com.example.controllers;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.TouristDto;
import com.example.entities.Tourist;
import com.example.services.ServiceResponse;
import com.example.services.TouristService;

import javafx.application.Application;

@RestController
public class TouristController {

	private final TouristService touristService;

	@Autowired
	public TouristController(TouristService touristService) {
		this.touristService = touristService;
	}
	
	@PostMapping("/saveTourist")
	public ResponseEntity<Object> saveTourist(@RequestBody Tourist tourist){
		System.out.println(tourist.getCountry());
		touristService.saveTourist(tourist);
		ServiceResponse<Tourist> response = new ServiceResponse<Tourist>("success", tourist);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
