package com.crud.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
private String name;
	

@ManyToMany(mappedBy = "subjects" )
@JsonBackReference
private List<Student> student;


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public List<Student> getStudent() {
	return student;
}


public void setStudent(List<Student> student) {
	this.student = student;
}
}
