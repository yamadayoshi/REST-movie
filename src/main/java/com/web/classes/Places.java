package com.web.classes;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown= true)
public class Places {
	private ArrayList<Result> results = new ArrayList<>();

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}
}
	
