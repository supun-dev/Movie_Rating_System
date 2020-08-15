package org.movieservice.movieinfoservice.controller;

import java.util.Collections;
import java.util.List;

import org.movieservice.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	public List<Movie> getMovieInfo(@PathVariable("movieId") String movieId)
	{
		return Collections.singletonList(new Movie("1102", "Guardians of the galaxy"));
	}
	
}
