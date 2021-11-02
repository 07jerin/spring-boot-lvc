package com.jerin.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jerin.demo.models.CatalogItem;
import com.jerin.demo.models.Movie;
import com.jerin.demo.models.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
	public CatalogItem getCatalogItem (Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
				Movie.class);
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
				
	}
	
	public CatalogItem getFallbackCatalogItem (Rating rating) {
		
		return new CatalogItem("Sample Name", "Sample Desc", rating.getRating());
				
	}
}
