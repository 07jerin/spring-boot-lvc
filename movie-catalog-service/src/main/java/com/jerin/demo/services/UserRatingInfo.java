package com.jerin.demo.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.jerin.demo.models.CatalogItem;
import com.jerin.demo.models.Rating;
import com.jerin.demo.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	public UserRatingInfo() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRating")
	public UserRating  getUserRating(@PathVariable("userId") String userId) {
		UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId,
				UserRating.class);
		
		return userRating;
	}
	
	public UserRating  getFallbackUserRating(@PathVariable("userId") String userId) {
		UserRating rating = new UserRating();
		rating.setUserId(userId);
		rating.setRatings(Arrays.asList(new Rating("100", 0)));
		return rating;
	}
	
}
