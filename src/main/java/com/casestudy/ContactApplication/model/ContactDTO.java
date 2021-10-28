package com.casestudy.ContactApplication.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class ContactDTO {

	private Long id;

	@Size(min=5, max=15)
	private String firstName;

	@Size(min=5, max=10)
	private String lastName;

	@NotNull
	@Min(20)
	@Max(80)
	private int age;

	@Email
    @Size(min=15, max=30)
	private String emailId;

	@NotNull
	private String gender;

	@Size(min=3, max=10)
	private String relation;

//	@NotNull
//	@Digits(integer = 10, fraction = 8)
//	@Range(min=8, max=10)
//	@Pattern(regexp = "(^$|[0-9]{10})")
	private Long phoneNumber;
	
//	private String image;

	public ContactDTO() {
	}

	public ContactDTO(String firstName, String lastName, int age, String emailId, String gender, String relation,
			Long phoneNumber) {
		super();
//        this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.emailId = emailId;
		this.gender = gender;
		this.relation = relation;
		this.phoneNumber = phoneNumber;
//		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
	

}
