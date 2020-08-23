package org.movieservice.moviecatalogsservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Movie {

	private String movieId;
	private String name;

	public Movie() {

	}

	public Movie(String movieId, String name) {
		this.movieId = movieId;
		this.name = name;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";

		try {
			jsonString = mapper.writeValueAsString(this);
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
