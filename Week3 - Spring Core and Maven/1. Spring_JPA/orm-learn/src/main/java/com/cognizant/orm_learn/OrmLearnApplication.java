package com.cognizant.orm_learn;

import com.cognizant.orm_learn.exception.CountryAlreadyExistsException;
import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		System.out.println("-------------------------------------------------------------------");
		LOGGER.info("Inside main");
		testGetAllCountries(context);
		System.out.println("----------------");
		getCountryByCode(context);
		System.out.println("----------------");
		addCountryByCode(context);
		System.out.println("----------------");
		updateCountryByCode(context);
		System.out.println("----------------");
		deleteCountryByCode(context);
		System.out.println("-------------------------------------------------------------------");
	}

	//Exercise 1
	private static void testGetAllCountries(ApplicationContext context) {
		LOGGER.info("Start");

		CountryService countryService = context.getBean(CountryService.class);
		List<Country> countries = countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	//Exercise 7
	private static void getCountryByCode(ApplicationContext context) {
		LOGGER.info("Start");

		CountryService countryService = context.getBean(CountryService.class);

		try {
			Country country = countryService.findCountryByCode("FR");
			LOGGER.debug("Country: {}", country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception occurred: {}", e.getMessage());
		}

		LOGGER.info("End");
	}

	//Exercise 8
	private static void addCountryByCode(ApplicationContext context) {
		LOGGER.info("Start");

		CountryService countryService = context.getBean(CountryService.class);

		Country newCountry = new Country();
		newCountry.setCode("SC");
		newCountry.setName("SatyaCity");

		try {
			countryService.addCountry(newCountry);
			LOGGER.debug("Added Country: {}", newCountry);
		} catch (CountryAlreadyExistsException e) {
			LOGGER.error(e.getMessage());
		}

		LOGGER.info("End");
	}

	//Exercise 8
	private static void updateCountryByCode(ApplicationContext context) {
		LOGGER.info("Start");

		CountryService countryService = context.getBean(CountryService.class);
		String code = "FR"; // Replace with a real code from your DB
		String newName = "Updated France";

		try {
			countryService.updateCountry(code, newName);
			Country updatedCountry = countryService.findCountryByCode(code);
			LOGGER.debug("Updated Country: {}", updatedCountry);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Update failed: {}", e.getMessage());
		}

		LOGGER.info("End");
	}

	//Exercise 9
	private static void deleteCountryByCode(ApplicationContext context) {
		LOGGER.info("Start");

		CountryService countryService = context.getBean(CountryService.class);
		String code = "MV"; // Replace with your test country code

		try {
			countryService.deleteCountry(code);
			LOGGER.debug("Country with code '{}' deleted successfully.", code);

			// Try fetching to confirm deletion
			countryService.findCountryByCode(code);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Deletion failed: {}", e.getMessage());
		}

		LOGGER.info("End");
	}
}
