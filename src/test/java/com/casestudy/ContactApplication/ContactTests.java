package com.casestudy.ContactApplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.casestudy.ContactApplication.entity.Contact;
import com.casestudy.ContactApplication.repository.IContactRepository;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ContactTests {

	@Autowired
	private IContactRepository repo;
	
	@Test
	@Order(1)
	@Rollback(false)
	public void testCreateContact() {
		Contact contact = new Contact("Jaipal", "Reddy",25, "mearavind@myself.com", "Male", "Friend", 9959963923L );
		Contact savedContact = repo.save(contact);
		
		assertNotNull(savedContact);
	}
	
	@SuppressWarnings("unused")
	@Test
	@Order(2)
	public void testFindContactById() {
		Long id = 1L;
		
		Optional<Contact> contact = repo.findById(id);
//		assertThat(contact.get()).isEqualTo(id);
		
	}
	
	@Test
	@Order(3)
	public void testFindContactByIdNotExist() {
		Long id = 1L;
		Optional<Contact> contact = repo.findById(id);
//		assertNull(contact);
		
	}
	
	@Test
	@Order(4)
//	@Rollback(false)
	public void testUpdateContact() {
		String contactFirstName = "Jaipal";
		Contact contact = new Contact(contactFirstName, "Reddy",25, "mearavind@myself.com", "Male", "Friend", 9959963923L );
		contact.setId(1L);
		
		repo.save(contact);
		
		Long contactId = 1L;
		Optional<Contact> updatedContact = repo.findById(contactId);	
//		assertThat(updatedContact.get()).isEqualTo(contactId);

	}
	
	@Test
	@Order(5)
	public void testListContacts() {
		List<Contact> contacts = (List<Contact>)repo.findAll();
		
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
//		assertThat(contacts).size().isGreaterThan(0);
		
	}
	
	@Test
	@Order(6)
	@Rollback(false)
	public void testdeleteContact() {
		Long id = 1L;
		
		boolean isExistBeforeDelete = repo.findById(id).isPresent();
		
		repo.deleteById(id);
		
		boolean notExistAfterDelete = repo.findById(id).isPresent();
		
//		assertTrue(isExistBeforeDelete);
//		assertTrue(notExistAfterDelete);
	}
	
}
