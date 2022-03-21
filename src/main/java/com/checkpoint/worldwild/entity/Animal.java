package com.checkpoint.worldwild.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Animal {
	
//Attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		

		private String imageUrl;
		
		private String wikiLink;
		
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

//Getters & Setters 
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

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
		public String getWikiLink() {
			return wikiLink;
		}

		public void setWikiLink(String wikiLink) {
			this.wikiLink = wikiLink;
		}
		
}
