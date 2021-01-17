package com.patjavahere.controller;

import java.time.LocalDate;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.patjavahere.model.Airline;

@RestController
public class ResourceController {

	/*
	 * @GetMapping("/staticFiltering") public Airline staticFiltering() {
	 * 
	 * LocalDate establishedDate = LocalDate.parse("2008-09-04"); Airline airLine =
	 * new Airline("Super Aviation", "AS23OIP8", establishedDate); return airLine; }
	 */
	@GetMapping("/dynamicFiltering")
	public MappingJacksonValue dynamicFiltering() {

		LocalDate date = LocalDate.parse("2008-09-04");
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("license",
				"establishedDate");
		// Adding filter using a id name
		FilterProvider filter = new SimpleFilterProvider().addFilter("dynamicAirlineFilter", propertyFilter);
		Airline airLine = new Airline("Super Aviation", "AS23", date);
		// Setting a filter
		MappingJacksonValue value = new MappingJacksonValue(airLine);
		value.setFilters(filter);
		return value;
	}
}