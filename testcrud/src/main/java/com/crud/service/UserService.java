package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.Dao;
import com.crud.model.Student;
import com.crud.model.Subject;

@Service
public class UserService {
	@Autowired
	Dao dao;
	
	
	public int savestudent(Student s) {
		int id= dao.savestudent(s);
		return id;
	}
	public int savesubject(Subject subject) {
		// TODO Auto-generated method stub
		int id=dao.savesubject(subject);
		return id;
	}
	public List<Student> getstduent() {
		
		// TODO Auto-generated method stub
		return dao.getstudent();
	}
public List<Subject> getsub() {
		
		// TODO Auto-generated method stub
		return dao.getsubject();
	}
public Student getStudentById(long id) {
	// TODO Auto-generated method stub
Student s=	dao.getstudentbyid(id);
	return s;
}
}
