package com.web.classes;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown= true)
public class Result {
	private String name;
	private String vicinity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVicinity() {
		return vicinity;
	}
	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}	
}
