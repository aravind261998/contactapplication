package com.casestudy.ContactApplication.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
	
	@Id
	@NotNull
	@Email
//	@Pattern(regexp = "/^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$/")
	@Size(min=15, max=30)
	@Column(name = "userId")
	private String userId;
	
	@NotNull
	@Size(min=6, max=15)
	@Column(name = "password")
	private String password;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(String userId, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
