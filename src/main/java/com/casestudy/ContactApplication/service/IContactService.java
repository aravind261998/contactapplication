package com.casestudy.ContactApplication.service;

import java.util.List;

import com.casestudy.ContactApplication.entity.Contact;
import com.casestudy.ContactApplication.model.ContactDTO;

public interface IContactService {
	public ContactDTO getContact(int id);
	
	public List<ContactDTO> getAllContacts();
	
	public ContactDTO addContact(Contact contact);
	
	public ContactDTO updateContact(Contact contact);
	
	public ContactDTO deleteContact(int id);

}
