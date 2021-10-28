package com.casestudy.ContactApplication.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.ContactApplication.entity.Contact;
@Repository
public interface IContactRepository extends JpaRepository<Contact, Long>{

	Optional<Contact> findById(Long Id);

	void deleteById(Long id);


}
