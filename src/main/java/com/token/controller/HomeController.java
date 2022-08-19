package com.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.token.model.JwtRequest;
import com.token.model.JwtResponse;
import com.token.service.UserService;
import com.token.utility.JWTUtility;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	@GetMapping("/")
	public String home() {
		return "Welcome to JWT demo Project";

	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					
		new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));			
					
					
		}catch (BadCredentialsException e) {
			
			throw new Exception("INVALID CREDENTIALS",e);
			
			
		}
		
		
		
		return null;

	}

}
