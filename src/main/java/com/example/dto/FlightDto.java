package com.example.dto;

import java.time.LocalDateTime;

public class FlightDto {

	private long id;
	private LocalDateTime departureDate;
	private LocalDateTime dateOfArrival;
	private int numberOfSeats = 11;
	private int ticketPrice;

	public FlightDto() {
		super();
	}

	public FlightDto(long id, LocalDateTime departureDate, LocalDateTime dateOfArrival, int numberOfSeats,
			int ticketPrice) {
		super();
		this.id = id;
		this.departureDate = departureDate;
		this.dateOfArrival = dateOfArrival;
		this.numberOfSeats = numberOfSeats;
		this.ticketPrice = ticketPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
