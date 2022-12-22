package com.example.springboot.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="contact_table")
@SequenceGenerator(name = "contact_us", sequenceName = "contact1", initialValue = 100)
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_us")
	@Column(name="contact_id")
	public long contact_id;
	
	
	@Column(name="first_name")
	@NotEmpty
	@Size(min=4 , message="firstName must contain atleast 4 characters")
	public String fullName;
	
	@Column(name="email_id")
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String email;
	@Column(name="subject")
	@NotEmpty
	@Size(min=10 , message="firstName must contain atleast 10 characters")
	public String subject;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "contact [fullName=" + fullName + ", email=" + email + ", subject=" + subject + "]";
	}
	

}
