package org.movieservice.movieinfoservice.controller;


import org.movieservice.movieinfoservice.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/movies")
public class MovieInfoController {

	Logger logger = LoggerFactory.getLogger(MovieInfoController.class);
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId)
	{
		logger.info(" ----- Method getMovieInfo started. Requested movie ID {} ----- \n " , movieId);
		return new Movie("1102", "Guardians of the galaxy");
	}
}
