package com.student.StudentData.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String first_name;
	private String last_name;
	private int class_number;
	private String section;
	private String email;
	private Double height;
	private Double weight;
	private String address;
	
	
	public Student() {
		super();
	}
	
	public Student(long id, String first_name, String last_name, int class_number, String section, String email,
			Double height, Double weight, String address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.class_number = class_number;
		this.section = section;
		this.email = email;
		this.height = height;
		this.weight = weight;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getClass_number() {
		return class_number;
	}
	public void setClass_number(int class_number) {
		this.class_number = class_number;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", class_number="
				+ class_number + ", section=" + section + ", email=" + email + ", height=" + height + ", weight="
				+ weight + ", address=" + address + "]";
	}
	
}
