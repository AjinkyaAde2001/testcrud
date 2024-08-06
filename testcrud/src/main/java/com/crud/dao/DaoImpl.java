package com.crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crud.model.Student;
import com.crud.model.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class DaoImpl implements Dao {
@PersistenceContext
	EntityManager et;
@Transactional
	@Override
	public int savestudent(Student student) {
		// TODO Auto-generated method stub
//		Session s= et.unwrap(Session.class);
        et.persist(student);
		return (int) student.getId();
	}
@Transactional
	@Override
	public int savesubject(Subject subject) {
		// TODO Auto-generated method stub
	et.persist(subject);
	
		return (int) subject.getId();
	}
@Transactional
@Override
public List<Student> getstudent() {
	// TODO Auto-generated method stub
	
	List<Student> list= et.createQuery( "select s from Student s" ,Student.class).getResultList();
	return list;
}
@Override
public List<Subject> getsubject() {
	// TODO Auto-generated method stub
	//Session s=et.unwrap(Session.class);
	List<Subject> sub=et.createQuery("from Subject",Subject.class).getResultList();
	return sub;
}
@Override
public Student getstudentbyid(Long id) {
	// TODO Auto-generated method stub
	 String sql = "select s from Student s where s.id = :id";
     Student student = et.createQuery(sql, Student.class)
                         .setParameter("id", id)
                         .getSingleResult();
     return student;
}

}

