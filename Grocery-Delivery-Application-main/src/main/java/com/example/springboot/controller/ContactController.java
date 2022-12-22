package com.example.springboot.controller;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Contact;
import com.example.springboot.repository.ContactRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController // is controller which provides different end points to access the services

@RequestMapping("/api/customers")
public class ContactController {
	
	@Autowired
	private ContactRepo contactRepo;
	
	
	@PostMapping("/contact")
	public  Contact saveCustomer(@RequestBody Contact contact) {

		return contactRepo.save(contact);
	}

	

}
