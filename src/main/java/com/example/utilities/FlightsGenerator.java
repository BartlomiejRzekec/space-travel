package com.example.utilities;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.springframework.data.jpa.provider.HibernateUtils;

import com.example.entities.Flight;
import com.example.entities.Tourist;

public class FlightsGenerator {
	
	
	public static List<String> listOfCountries() throws IOException, URISyntaxException {
		
		Stream<String> countries = Files.lines(Paths.get(ClassLoader.getSystemResource("countries.txt").toURI()));
		
		return countries.map(e -> e.split("\\|"))
						.flatMap(Arrays::stream)
						.filter(e -> e.length() > 2)
						.collect(Collectors.toList());
	}
	
	private static LocalDate date() {
	    return LocalDate.ofEpochDay(ThreadLocalRandom
	      .current().nextInt(-(50 * 365), 50 * 365));
	}
	
	private static LocalDateTime dateTime() {
		LocalDateTime now  = LocalDateTime.now();
		return now.plusMinutes(ThreadLocalRandom.current().nextInt(10 * 365 * 24 * 60));
	}
	
	public static List<Tourist> generateListOfTourists() throws IOException, URISyntaxException{
		List<Tourist> list = new ArrayList<>();
		int size = (int) Math.random() * 11;
		for(int i = 0; i < 200; i++) {
			list.add(generateTourist());
		}
		return list;
	}
	
	public static Tourist generateTourist() throws IOException, URISyntaxException {
		Tourist tourist = new Tourist();
		tourist.setFirstName(firstNames.get((int) Math.random() * firstNames.size()));
		tourist.setLastName(lastNames.get((int) Math.random() * lastNames.size()));
		tourist.setGender(genders.get((int) Math.random() * 1));
		tourist.setCountry(listOfCountries().get((int) Math.random() * listOfCountries().size()));
		tourist.setNotes("some notes");
		tourist.setBirthDate(date());
		return tourist;
	}
	
	public static Flight generateFlight() {
		Flight flight = new Flight();
		LocalDateTime departmentDate = dateTime();
		flight.setDateOfArrival(departmentDate);
		flight.setDepartureDate(departmentDate.plusMinutes(30 * 24 * 60));
		flight.setNumberOfSeats(11);
		flight.setTicketPrice((int) ((Math.random() * 5) + 1) * 1000);
		return flight;
	}
	
	
	static List<String> genders = Arrays.asList("male", "female");

	static List<String> firstNames = Arrays.asList("Allison", "Arthur", "Alex", "Arnold", "Arthur", "Adelle", "Adrea", "Adriana",
											"Bambi", "Barbabra", "Brandy", "Bridgette", "Camila", "Carla", "Carmen", "Christian",
											"Daisy", "Dasha", "Emily", "Erik", "Gabriel", "Gennifer", "Irina", "Jackie",
											"Janella", "Katherina", "Katya", "Kris", "Leila", "Linette", "Lois", "Madeline",
											"Margie", "Micky", "Midge", "Niki", "Octavia", "Pamella", "Pauly", "Pauline",
											"Perry", "Rachael", "Rafael", "Rebbecca", "Robbyn", "Sande", "Sharleen", "Sidoney",
											"Suzie", "Tasia", "Theadora", "Tiffani", "Tony", "Trude", "Valeria", "Zuzana");
			
			
	static List<String> lastNames = Arrays.asList("Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast",
										   "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", 
										   "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", 
										   "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", 
										   "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss",
										   "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal",
										   "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin",
										   "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills",
										   "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", 
										   "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer",
										   "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler");
}
