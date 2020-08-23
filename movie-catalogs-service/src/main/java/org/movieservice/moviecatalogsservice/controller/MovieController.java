package org.movieservice.moviecatalogsservice.controller;

import org.movieservice.moviecatalogsservice.model.CatalogItem;
import org.movieservice.moviecatalogsservice.model.Movie;
import org.movieservice.moviecatalogsservice.model.Rating;
import org.movieservice.moviecatalogsservice.model.UserRating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/Catalog")
public class MovieController {

	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getStatus(@PathVariable("userId") String userId) {
		
		//In the URL, we give the service name as registered in Eureka Server (MOVIE-RATINGS-SERVICE)
		UserRating userRating = restTemplate.getForObject("http://MOVIE-RATINGS-SERVICE/ratingsData/users/1102", UserRating.class);
		List<CatalogItem> listCatalogItems = new ArrayList<>();

		for (Rating rating : userRating.getListUserRatings()) {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/1102", Movie.class);
			logger.info("Movie Details from Movie Info Service : {} " , movie.toString());
			CatalogItem catelogItem = new CatalogItem(movie.getName(), "Save Humanity", rating.getRating());
			listCatalogItems.add(catelogItem);
		}

		return listCatalogItems;
	}

}
