package com.casestudy.ContactApplication.service;

import java.util.List;
import java.util.Optional;

import com.casestudy.ContactApplication.entity.User;

public interface IUserService {

	public Optional<User> findByUserId(String userId);

	public User validateUser(User user);

	public User addUser(User user);

	public User removeUser(User user);

	public List<User> viewAllUsers();

	//public List<User> viewAllByRole(String role);

}
