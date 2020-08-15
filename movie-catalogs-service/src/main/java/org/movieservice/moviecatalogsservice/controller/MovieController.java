package org.movieservice.moviecatalogsservice.controller;

import org.movieservice.moviecatalogsservice.model.CatalogItem;
import org.movieservice.moviecatalogsservice.model.Movie;
import org.movieservice.moviecatalogsservice.model.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/Catalog")
public class MovieController {

	@GetMapping("/{userId}")
	public List<CatalogItem> getStatus(@PathVariable("userId") String userId) {

		RestTemplate restTemplate = new RestTemplate();

		List<Rating> listRating = Arrays.asList(new Rating("Train to Busan", 8), new Rating("Australia", 9));
		List<CatalogItem> listCatalogItems = new ArrayList<>();

		for (Rating rating : listRating) {
			String smovie = restTemplate.getForObject("http://127.0.0.1:8082/movies/1102", String.class);
			System.out.println("Movie : " + smovie);
			Movie movie = restTemplate.getForObject("http://127.0.0.1:8082/movies/1102", Movie.class);
			CatalogItem catelogItem = new CatalogItem(movie.getName(), "Save Humanity", rating.getRating());
			listCatalogItems.add(catelogItem);
		}

		return listCatalogItems;
	}

}
