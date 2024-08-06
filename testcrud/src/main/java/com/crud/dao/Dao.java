package com.crud.dao;

import java.util.List;

import com.crud.model.Student;
import com.crud.model.Subject;

public interface Dao {
public int savestudent(Student student);

public int savesubject(Subject subject);

public List<Student> getstudent();

public List<Subject> getsubject();

public Student getstudentbyid(Long id);

public Subject getsubyid(Long id);

}
