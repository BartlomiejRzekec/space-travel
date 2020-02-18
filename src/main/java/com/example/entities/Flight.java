package com.example.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private LocalDateTime departureDate;
	private LocalDateTime dateOfArrival;
	private int numberOfSeats;
	private int ticketPrice;
	
	
	@ManyToMany(mappedBy="listOfFlights", cascade=CascadeType.ALL)
	private List<Tourist> listOfTourists;

	public Flight(LocalDateTime departureDate, LocalDateTime dateOfArrival, int numberOfSeats, int ticketPrice,
			List<Tourist> listOfTourists) {
		this.departureDate = departureDate;
		this.dateOfArrival = dateOfArrival;
		this.numberOfSeats = numberOfSeats;
		this.ticketPrice = ticketPrice;
		this.listOfTourists = listOfTourists;
	}

	public Flight() {
		
	}
	
	public void addTourist(Tourist tourist) {
		this.listOfTourists.add(tourist);
		tourist.getListOfFlights().add(this);
	}

	public long getId() {
		return id;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDateTime dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public List<Tourist> getListOfTourists() {
		return listOfTourists;
	}

	public void setListOfTourists(List<Tourist> listOfTourists) {
		this.listOfTourists = listOfTourists;
	}

}
