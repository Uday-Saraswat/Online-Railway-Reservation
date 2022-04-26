package com.casestudy.uday.controller;

import com.casestudy.uday.model.JwtRequest;
import com.casestudy.uday.model.JwtResponse;
import com.casestudy.uday.model.UserModel;
import com.casestudy.uday.model.UserRepository;
import com.casestudy.uday.service.UserService;
import com.casestudy.uday.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

	
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	AuthenticationManager authenticates;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	JwtUtils jwtutil;
	
	@PostMapping("/adduser")
	private ResponseEntity<JwtResponse>addUser(@RequestBody JwtRequest jwtreq){
		UserModel usermodel =new UserModel();
		
		usermodel.setUsername(jwtreq.getUsername());
		usermodel.setPassword(jwtreq.getPassword());
		
		
		try {
			userrepo.save(usermodel);
		}
		catch(Exception e){
			return new ResponseEntity<JwtResponse>(new JwtResponse
					("Error during adding ") , HttpStatus.OK);
		}
		
		return new ResponseEntity<JwtResponse>(new JwtResponse
				("Successful created User :-  " +jwtreq.getUsername()), HttpStatus.OK);
//		return ResponseEntity.ok(new AuthenticationResponse());
	}
	
	
	@PostMapping("/auth")
	private ResponseEntity<?> authenticateUser(@RequestBody JwtRequest jwtreq){
		String username=jwtreq.getUsername();
		String password= jwtreq.getPassword();
		try {
			authenticates.authenticate(new UsernamePasswordAuthenticationToken(username, password));
				
		}
		catch(Exception e) {
			return ResponseEntity.ok(new JwtResponse(" Invalid Credentials...!"));
		}
		
		UserDetails userdetails= userservice.loadUserByUsername(username);
		
		String jwt = jwtutil.generateToken(userdetails);
		
		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	
	@GetMapping("/test")
	private String testingtoken() {
		try {
			return "Testing Successful...!";	
		}
		catch(Exception e) {
			return "Please login first..!";
		}
	}
	
	@GetMapping("/dashboard")
	private String dashboard() {
		return "Welcome to dashboard...!";
	}
	
	
	
}
