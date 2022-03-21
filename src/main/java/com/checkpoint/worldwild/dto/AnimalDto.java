package com.checkpoint.worldwild.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AnimalDto {
//DTO attributes
	
	private String imageUrl;
	
	@NotBlank
	@Size(min=3, max=100)
	private String name;
	
	@NotBlank
	@Size(min=3,max=100)
	private String race;
	
	@NotBlank
	@Size(min=3,max=100)
	private String size;
	
	@NotBlank
	@Size(min=3,max=100)
	private String weight;
	
	@NotBlank
	@Size(min=3,max=100)
	private String life;
	
	@NotBlank
	@Size(min=3,max=100)
	private String feed;

//DTO Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}

	public String getFeed() {
		return feed;
	}

	public void setFeed(String feed) {
		this.feed = feed;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
}
