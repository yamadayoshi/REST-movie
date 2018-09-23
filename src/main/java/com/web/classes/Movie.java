package com.web.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable{	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	private String title;
	private String genre;
	private String cover;	
	private String category;
	private String description;
	private String imageDetail;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}		
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

	public String getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}

	@Override
	public String toString() {		
		return getId() + " " + getTitle() + " " + getGenre() + " " + getCategory() + " " + getDescription();
	}
}
