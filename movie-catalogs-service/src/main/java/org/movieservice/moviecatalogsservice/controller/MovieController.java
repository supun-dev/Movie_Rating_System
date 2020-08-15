package org.movieservice.moviecatalogsservice.controller;

import org.movieservice.moviecatalogsservice.model.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/Catalog")
public class MovieController {

	@GetMapping("/{userId}")
	public List<CatalogItem> getStatus(@PathVariable("userId") String userId) {
		return Collections.singletonList(new CatalogItem(userId, "Save Humanity", 8));
	}

}
