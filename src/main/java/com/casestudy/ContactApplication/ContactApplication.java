package com.casestudy.ContactApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ContactApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(ContactApplication.class, args);
	}

}
