package com.jerin.demo.resource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.jerin.demo.models.CatalogItem;
import com.jerin.demo.models.Movie;
import com.jerin.demo.models.UserRating;
import com.jerin.demo.services.MovieInfo;
import com.jerin.demo.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	public CatalogResource() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private MovieInfo movieInfo;
	
	@Autowired
	private UserRatingInfo userRatingInfo;
	

	@Autowired
	WebClient.Builder webClientBuilder;

	@RequestMapping("/{userId}")
//	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		UserRating userRating = userRatingInfo.getUserRating(userId);
		
		 List<CatalogItem> items =  userRating.getRatings().stream()
				.map(rating -> movieInfo.getCatalogItem(rating))
				.collect(Collectors.toList());
		 return items;
	}
	
//	public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
//		return Arrays.asList(new CatalogItem("No movie, server getting upgraded", "", 0));
//				
//	}
//	/Web client error
//	@RequestMapping("/testwebclient")
//	public Movie getMovie() {
//		Movie movie  = webClientBuilder.build().get()
//				.uri("http://movie-info-service/movies/123")
//				.retrieve()
//				.bodyToMono(Movie.class).block();
//		
//		return movie;
//	}

}
