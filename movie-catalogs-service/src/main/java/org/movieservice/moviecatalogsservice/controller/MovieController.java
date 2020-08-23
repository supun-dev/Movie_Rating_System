package org.movieservice.moviecatalogsservice.controller;

import org.movieservice.moviecatalogsservice.model.CatalogItem;
import org.movieservice.moviecatalogsservice.model.Movie;
import org.movieservice.moviecatalogsservice.model.Rating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@RestController
@RequestMapping("/Catalog")
@Slf4j 
public class MovieController {

	Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getStatus(@PathVariable("userId") String userId) {
		
		List<Rating> listRating = Arrays.asList(new Rating("Train to Busan", 8), new Rating("Australia", 9));
		List<CatalogItem> listCatalogItems = new ArrayList<>();

		for (Rating rating : listRating) {
			Movie movie = restTemplate.getForObject("http://127.0.0.1:8082/movies/1102", Movie.class);
			logger.info("Movie Details from Movie Info Service : {} " , movie.toString());
			CatalogItem catelogItem = new CatalogItem(movie.getName(), "Save Humanity", rating.getRating());
			listCatalogItems.add(catelogItem);
		}

		return listCatalogItems;
	}

}
