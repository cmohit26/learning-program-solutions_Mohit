package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.exception.CountryAlreadyExistsException;
import com.cognizant.orm_learn.exception.CountryNotFoundException;
import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Exercise 1
    @Transactional
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    //Exercise 6
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
        Optional<Country> result = countryRepository.findById(countryCode);

        if (!result.isPresent()) {
            throw new CountryNotFoundException("Country not found with code: " + countryCode);
        }

        return result.get();
    }

    //Exercise 7
    @Transactional
    public void addCountry(Country country) throws CountryAlreadyExistsException {
        // Check if country with the same code already exists
        Optional<Country> existingCountry = countryRepository.findById(country.getCode());

        if (existingCountry.isPresent()) {
            String existingName = existingCountry.get().getName();
            throw new CountryAlreadyExistsException(
                    "Country with code " + country.getCode() + " already exists. " +
                            "Existing Country Name: " + existingName);
        }

        // Save the new country
        countryRepository.save(country);
    }

    //Exercise 8
    @Transactional
    public void updateCountry(String code, String name) throws CountryNotFoundException {
        Optional<Country> optionalCountry = countryRepository.findById(code);

        if (optionalCountry.isPresent()) {
            Country country = optionalCountry.get();
            country.setName(name); // update name
            countryRepository.save(country); // save updated country
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }
    }

    //Exercise 9
    @Transactional
    public void deleteCountry(String code) throws CountryNotFoundException {
        Optional<Country> country = countryRepository.findById(code);

        if (country.isPresent()) {
            countryRepository.deleteById(code);
        } else {
            throw new CountryNotFoundException("Country with code " + code + " not found.");
        }
    }


}
