package org.movieservice.movieratingsservice.model;

import java.util.List;

import lombok.Data;

@Data
public class UserRating {

	private List<Rating> listUserRatings;
	
}
