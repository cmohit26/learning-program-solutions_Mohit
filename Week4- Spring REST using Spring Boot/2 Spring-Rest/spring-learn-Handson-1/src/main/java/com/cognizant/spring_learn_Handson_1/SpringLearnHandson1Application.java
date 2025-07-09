package com.cognizant.spring_learn_Handson_1;

import com.cognizant.spring_learn_Handson_1.entity.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
@ImportResource("classpath:country.xml")  // 🔁 This is critical!
public class SpringLearnHandson1Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnHandson1Application.class);

	public static void main(String[] args) {
		LOGGER.info("SpringLearnApplication is starting...");
		SpringApplication.run(SpringLearnHandson1Application.class, args);
		System.out.println("------------------------------------------------");
		//displayDate(); //Exercise 3
		System.out.println("------------------------------------------------");
//		displayCountry(); //Exercise 4 and 5
		System.out.println("------------------------------------------------");
	}

	public static void displayDate() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);

		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug("Parsed date: {}", date);
		} catch (Exception e) {
			LOGGER.error("Error parsing date", e);
		}

		LOGGER.info("END");
	}

	public static void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("countryIN", Country.class);
		Country anotherCountry = context.getBean("countryIN", Country.class);

		LOGGER.debug("Country 1 : {}", country.toString());
		LOGGER.debug("Country 2 : {}", anotherCountry);

		LOGGER.info("END");
	}



}