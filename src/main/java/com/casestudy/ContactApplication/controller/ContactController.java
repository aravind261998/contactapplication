package com.casestudy.ContactApplication.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.casestudy.ContactApplication.entity.Contact;
import com.casestudy.ContactApplication.exception.ResourseNotFoundException;
import com.casestudy.ContactApplication.repository.IContactRepository;
import com.casestudy.ContactApplication.utils.FileUploadUtil;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")

public class ContactController {
	@Autowired
	private IContactRepository contactRepository;
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}
	
//	@PostMapping("/contacts")
//	public Contact createContact(@RequestBody Contact contact) {
//		return contactRepository.save(contact);
//	}
	
	@PostMapping("/contacts")
	public ResponseEntity<Contact> createContact(@RequestBody Contact contact) throws IOException  {
//		, @RequestParam("image") MultipartFile multipartFile
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//        contact.setImage(fileName);
        Contact savedContact = contactRepository.save(contact);

//        String uploadDir = "contact-photos/" + savedContact.getId();
//        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		Contact contact1 = contactRepository.save(contact);
		return ResponseEntity.ok(contact1);
	}
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
		Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Contact not exist id: " +id));
		return ResponseEntity.ok(contact);
	}
	
	  
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Contact not exist with id:" +id));
		contact.setFirstName(contactDetails.getFirstName());
		contact.setLastName(contactDetails.getLastName());
		contact.setAge(contactDetails.getAge());
		contact.setEmailId(contactDetails.getEmailId());
		contact.setGender(contactDetails.getGender());
		contact.setRelation(contactDetails.getRelation());
		contact.setPhoneNumber(contactDetails.getPhoneNumber());
		//contact.updatedContact = contactRepository.save(contact);
		contact = contactRepository.save(contact);
		return ResponseEntity.ok(contact);	
		
	}
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContact(@PathVariable Long id) {
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Contact not exist id:" +id));
		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}
