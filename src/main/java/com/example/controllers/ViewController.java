package com.example.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.utilities.FlightsGenerator;

@Controller
public class ViewController {

	
	@GetMapping("/touristForm")
	public String touristForm(Model model) throws IOException, URISyntaxException {
		
		model.addAttribute("countries", FlightsGenerator.listOfCountries());
		return "touristForm";
	}
	
}
