package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	
	@Column(name = "first_name")
private String firstname;
	
	@Column(name = "last_name")
private String lastname;
	
	
	@Column(name = "email_id")
private String emailid;
	
	
	@Column(name = "salary")
private long salary;
	
	@Column(name = "phone_no")
private long phoneno;

public Employee() {}

public Employee(long id, String firstname, String lastname, String emailid, long salary, long phoneno) {
	super();

	this.firstname = firstname;
	this.lastname = lastname;
	this.emailid = emailid;
	this.salary = salary;
	this.phoneno = phoneno;
}



public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public long getSalary() {
	return salary;
}
public void setSalary(long salary) {
	this.salary = salary;
}
public long getPhoneno() {
	return phoneno;
}
public void setPhoneno(long phoneno) {
	this.phoneno = phoneno;
}
}
