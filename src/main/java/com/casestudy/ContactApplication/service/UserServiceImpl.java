package com.casestudy.ContactApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.ContactApplication.entity.User;
import com.casestudy.ContactApplication.exception.InvalidLoginException;
import com.casestudy.ContactApplication.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserRepository userRepo;
	@Override
	public User validateUser(User user) {
		//TODO Auto Generated Method Stub
		Optional<User> Obj = userRepo.viewByUserId(user.getUserId());
		
		String pwd = Obj.get().getPassword();
		System.out.println(pwd);
		if(!pwd.equals(user.getPassword())) {
			throw new InvalidLoginException("Wrong Password");
		}
		return user;
	}
	@Override
	public Optional<User> findByUserId(String userId) {
		Optional<User> use = userRepo.viewByUserId(userId);
		// TODO Auto-generated method stub
		return use ;
	}
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		return user;
	}
	@Override
	public User removeUser(User user) {
		// TODO Auto-generated method stub
		userRepo.delete(user);
		return user;
	}
	@Override
	public List<User> viewAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
//	@Override
//	public List<User> viewAllByRole(String role) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
	
	


