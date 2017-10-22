package edu.ldcollege.bean;

import com.fasterxml.jackson.annotation.JsonView;

public class Book {
	@JsonView(View.Summary.class)
	private Long id;
	@JsonView(View.Summary.class)
	private String title;
	private String city;
	private String country;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
