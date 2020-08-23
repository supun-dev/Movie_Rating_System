package org.movieservice.movieratingsservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.movieservice.movieratingsservice.model.Rating;
import org.movieservice.movieratingsservice.model.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsData")
public class MovieRatingController {

	@GetMapping("/{movieId}")
	public List<Rating> getStatus(@PathVariable("movieId") String movieId) {
		return Collections.singletonList(new Rating(movieId, 7));
	}

	@GetMapping("users/{userId}")
	public UserRating getUserRatings(@PathVariable("userId") String userId) {
		List<Rating> userRatings = Arrays.asList(new Rating("1234", 5), new Rating("5678", 8));

		UserRating userRating = new UserRating();
		userRating.setListUserRatings(userRatings);

		return userRating;
	}
}
