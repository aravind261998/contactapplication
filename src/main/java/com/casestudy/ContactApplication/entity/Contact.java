package com.casestudy.ContactApplication.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import java.lang.annotation.*;

@Entity
@Table(name="ContactDetails")
public class Contact {

//    public static Contact builder;

//	@Transient
//    public String getPhotosImagePath() {
//        if (image == null || id == null) return null;
//         
//        return "/user-photos/" + id + "/" + image;
//    }
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Size(min=5, max=20)
    @Column(name = "firstName")
    private String firstName;

	@Size(min=5, max=10)
    @Column(name = "lastName")
    private String lastName;

	@NotNull
	@Min(20)
	@Max(80)
    @Column(name = "age")
    private int age;

    @Email
    @Size(min=15, max=30)
    @Column(name = "emailId")
    private String emailId;

    @NotNull
    @Column(name = "gender")
    private String gender;

	@Size(min=3, max=10)
    @Column(name = "relation")
    private String relation;
    
	
    @Column(name = "phoneNumber")
    private Long phoneNumber;
    
//    @Column(nullable=true, length=64)
//    private String image;
    



//	public Contact updatedContact;

    public Contact() {
    }

    public Contact(String firstName, String lastName, int age, String emailId, String gender, String relation, Long phoneNumber) {
        super();
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailId = emailId;
        this.gender = gender;
        this.relation = relation;
        this.phoneNumber = phoneNumber;
//        this.image = image;
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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", emailId=" + emailId + ", gender=" + gender + ", relation=" + relation + ", phoneNumber="
				+ phoneNumber + "]";
	}

//	public Contact orElseThrow(Object object) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
