package com.web.classes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id	
	private int id;
	private String genre;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
}
