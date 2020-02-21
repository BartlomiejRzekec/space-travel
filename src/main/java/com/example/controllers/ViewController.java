package com.example.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.FlightDto;
import com.example.dto.TouristDto;
import com.example.entities.Flight;
import com.example.entities.Tourist;
import com.example.services.FlightService;
import com.example.services.TouristService;
import com.example.utilities.FlightsGenerator;

@Controller
public class ViewController {
	
	private final TouristService touristService;
	private final FlightService flightService;
	
	@Autowired
	public ViewController(TouristService touristService, FlightService flightService) {
		this.touristService = touristService;
		this.flightService = flightService;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@PostMapping("/flightSearcher")
	public String findFlight( @ModelAttribute Flight flight, Model model,  RedirectAttributes redirectAttributes) {
		List<Flight> flightsList = flightService.findFlight(flight.getDepartureDate(), flight.getDateOfArrival());
		redirectAttributes.addFlashAttribute("flightsList", flightsList);
		return "redirect:/editFlight";
	}
	
	@GetMapping("/flightManager")
	public String flightManager(Model model) {
		List<FlightDto> flightsList = flightService.findAllFlights();
		model.addAttribute("flightsList", flightsList);
		return "flightManager";
	}
	
	@GetMapping("/flightForm")
	public String flightForm() {
		return "flightForm";
	}
	
	@GetMapping("/editFlight")
	public String editFlight(long id, Model model) throws IOException, URISyntaxException {
		Flight flightToEdit = flightService.findFlight(id);
		model.addAttribute("flightToEdit", flightToEdit);
		return "flightFormEdit";
	}
	
	@PostMapping("/editFlight")
	public String editFlight(@ModelAttribute Flight flight) {
		flightService.saveFlight(flight);
		return "redirect:/flightManager";
	}
	
	@GetMapping("/deleteFlight")
	public String deleteFlight(long id) {
		Flight flightToDelete = flightService.findFlight(id);
		flightService.deleteFlight(flightToDelete);
		return "redirect:/flightManager";
	}

	@GetMapping("/touristForm")
	public String touristForm(Model model) throws IOException, URISyntaxException {
		model.addAttribute("countries", FlightsGenerator.listOfCountries());
		return "touristForm";
	}
	
	@GetMapping("/touristManager")
	public String findAllTourists(Model model) {
		List<TouristDto> touristsList = touristService.findAllTourists();
		model.addAttribute("touristsList", touristsList);
		return "touristManager";
	}
	
	@GetMapping("/editTourist")
	public String editTourists(long id, Model model) throws IOException, URISyntaxException {
		Tourist touristToEdit = touristService.findTourist(id);
		model.addAttribute("touristToEdit", touristToEdit);
		model.addAttribute("countries", FlightsGenerator.listOfCountries());
		return "touristFormEdit";
	}
	
	@PostMapping("/editTourist")
	public String editTourist(@ModelAttribute Tourist tourist) {
		touristService.saveTourist(tourist);
		return "redirect:/touristManager";
	}
	
	@GetMapping("/deleteTourist")
	public String deleteTourists(long id) {
		Tourist touristToDelete = touristService.findTourist(id);
		touristService.deleteTourist(touristToDelete);
		return "redirect:/touristManager";
	}
}
