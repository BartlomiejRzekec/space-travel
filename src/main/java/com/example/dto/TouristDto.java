package com.example.dto;

import java.time.LocalDate;

import com.example.entities.Tourist;

public class TouristDto {
	
	
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private LocalDate birthDate;
	
	
	
	public TouristDto(long id, String firstName, String lastName, String gender, String country, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.birthDate = birthDate;
	}
		
		
	public static TouristDto buildDto(Tourist tourist) {
		return new TouristDto(tourist.getId(), tourist.getFirstName(), tourist.getLastName(), tourist.getGender(), tourist.getCountry(), tourist.getBirthDate());
	}
		
	
	public TouristDto() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
