package com.cognizant.spring_learn_Handson_1.controller;

import com.cognizant.spring_learn_Handson_1.service.CountryService;
import com.cognizant.spring_learn_Handson_1.entity.Country;
import com.cognizant.spring_learn_Handson_1.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    // Inject the specific country bean named "countryIN"
    @Autowired
    @Qualifier("countryIN")
    private Country countryIndia;

    // Inject the list of countries defined as "countryList"
    @Autowired
    @Qualifier("countryList")
    private List<Country> countries;

    // Return the specific country (India)
    @GetMapping("/country")
    public Country getCountryIndia() {
        return countryIndia;
    }

    // Return all countries
    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countries;
    }

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
        return countryService.getCountry(code);
    }

}
