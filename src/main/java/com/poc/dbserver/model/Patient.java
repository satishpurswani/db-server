package com.poc.dbserver.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(name="name")
	String name;
	
	public Patient() {
		super();
	}

	public Patient(String name, int age, String gender, Long accessionNumber, Date dob) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.accessionNumber = accessionNumber;
		this.dob = dob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAccessionNumber() {
		return accessionNumber;
	}

	public void setAccessionNumber(Long accessionNumber) {
		this.accessionNumber = accessionNumber;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name="age")
	int age;
	
	@Column(name="gender", length = 1)
	String gender;
	
	@Column(name="accessionNumber")
	Long accessionNumber;
	
	@Column(name="dob")
	Date dob;
}
