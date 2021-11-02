package com.jerin.springsecurityjwt.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	private final String jwt;

	public String getJwt() {
		return jwt;
	}
	

}
