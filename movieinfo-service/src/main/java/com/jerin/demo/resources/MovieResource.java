package com.jerin.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jerin.demo.models.Movie;
import com.jerin.demo.models.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {

	public MovieResource() {
		// TODO Auto-generated constructor stub
	}

	@Value("${api.key}")
	private String apiKey;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"
				 + movieId + "?api_key=" + apiKey,
				MovieSummary.class);
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}

}