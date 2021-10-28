package com.casestudy.ContactApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.ContactApplication.entity.User;
import com.casestudy.ContactApplication.exception.DuplicateIdFoundException;
import com.casestudy.ContactApplication.exception.NotFoundException;
import com.casestudy.ContactApplication.repository.IUserRepository;
import com.casestudy.ContactApplication.service.IUserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/rest/users")
public class UserController {
	
	@Autowired
	IUserService service;
	@Autowired
	IUserRepository userRepo;

	/**********************Controller Call for Validating User Login******************/
	
	@PostMapping(path="/validate", produces = "application/json")
	public ResponseEntity<User> getAll(@ RequestBody User user) {
		Optional<User> use = service.findByUserId(user.getUserId());
		if(!use.isPresent()) {
			throw new NotFoundException("No user is present with id " + user.getUserId());
		}
		User str=service.validateUser(user);
		return new ResponseEntity<User>(str, HttpStatus.OK);
		
	}
	
	/***********************Controller Call for Adding new User to Database
	@param userRepo ****************/
//	path="/addUser"
	@PostMapping(path="/addUser", produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody User user) throws DuplicateIdFoundException {
		User result;
		Optional<User> use = service.findByUserId(user.getUserId());
		if(use.isPresent()) {
			throw new DuplicateIdFoundException("User id " + user.getUserId() + " is already present");
		}
		else {
//			result = service.addUser(user);
			result = userRepo.save(user);
		}
		return new ResponseEntity<User>(result, HttpStatus.OK);
		
	}
	
	/************************Controller Call for Deleting User from database***************/
	
	@DeleteMapping(path="/delete/{userId}")
	public ResponseEntity<User> deleteById(@PathVariable("userId") String userId)
	throws NotFoundException {
		Optional<User> use = service.findByUserId(userId);
		if(!use.isPresent()) {
			throw new NotFoundException("No user is present with id " + userId);
		}
		User user =service.removeUser(use.get());
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	/************************Controller Call for Listing All Users from Database*************/
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() throws NotFoundException {
		List<User> result = service.viewAllUsers();
		if(result.isEmpty()) {
			throw new NotFoundException("There are no users to display.");
		}
		return new ResponseEntity<List<User>> (result, HttpStatus.OK);
	}	


}
