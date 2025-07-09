package com.cognizant.spring_learn_Handson_1.service;

import com.cognizant.spring_learn_Handson_1.entity.Country;
import com.cognizant.spring_learn_Handson_1.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private List<Country> countries;

    public Country getCountry(String code) {
        // Lambda expression to find the country
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country with code " + code + " not found"));
    }
}
