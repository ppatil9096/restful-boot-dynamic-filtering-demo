package com.patjavahere.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("dynamicAirlineFilter")
public class Airline {
	private String name;
//	@JsonIgnore // annotation used to ignore the field [static filtering]
	private String license;
	private LocalDate establishedDate;

	public Airline(String name, String license, LocalDate establishedDate) {
		this.name = name;
		this.license = license;
		this.establishedDate = establishedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public LocalDate getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(LocalDate establishedDate) {
		this.establishedDate = establishedDate;
	}

}
