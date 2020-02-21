package com.example.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Tourist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String notes;
	private LocalDate birthDate;
	
	@ManyToMany(mappedBy="listOfTourists")
	@Fetch(FetchMode.JOIN)
	private List<Flight> listOfFlights;

	public Tourist(String firstName, String lastName, String gender, String country, String notes, LocalDate birthDate,
			List<Flight> listOfFlights) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.notes = notes;
		this.birthDate = birthDate;
		this.listOfFlights = listOfFlights;
	}
	
	

	public Tourist(long id, String firstName, String lastName, String gender, String country, LocalDate birthDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.birthDate = birthDate;
	}



	public Tourist() {
		
	}
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Flight> getListOfFlights() {
		return listOfFlights;
	}

	public void setListOfFlights(List<Flight> listOfFlights) {
		this.listOfFlights = listOfFlights;
	}
}
