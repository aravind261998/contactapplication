package com.casestudy.ContactApplication.repository;

//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.ContactApplication.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

	
	@Query("select us from User us where us.userId=?1")
	public Optional<User> viewByUserId(String userId);

}
