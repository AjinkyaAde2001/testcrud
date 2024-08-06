package com.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Student;
import com.crud.model.StudentDto;
import com.crud.model.Subject;
import com.crud.model.SubjectDto;
import com.crud.service.UserService;
@CrossOrigin
@RestController
public class MainController {
@Autowired
UserService service;

	@RequestMapping("/test")
	public String test() {
		return "hi";
		
	}
	@PostMapping("/student/save")
	public ResponseEntity<String> saveStudent(@RequestBody StudentDto studentDTO){
	
		Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAddress(studentDTO.getAddress());
        List<Subject> subjects = new ArrayList<>();
        for (Long id : studentDTO.getSubjectIds()) {
            Subject subject = new Subject();
            subject.setId(id);
            subjects.add(subject);
        }
        
        student.setSubjects(subjects);
        
		int status=service.savestudent(student);
		
		try {
			return new ResponseEntity<>("Student saved with id "+status, HttpStatus.CREATED);
} catch (Exception e) {
// Return an error message with status INTERNAL_SERVER_ERROR
	  return new ResponseEntity<>("Error saving student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
	}
		@PostMapping("/subject/save") 
		public String saveSubject(@RequestBody SubjectDto subjectd){
			Subject subject=new Subject();
			subject.setName(subjectd.getName());
			int status=service.savesubject(subject);
			return "saved student with id "+status;
			
			
		}
       @GetMapping("/student/list")
       public ResponseEntity<List<Student>> getstudent(){
    	   try {
    	List<Student> list= service.getstduent();
    	
    	 for (Student student : list) {
    		 System.out.println("--------------------------------------------------");
             System.out.println("Student ID: " + student.getId());
             System.out.println("Name: " + student.getName());
             System.out.println("Address: " + student.getAddress());
             
             System.out.println("Subjects:");
    	 }
            return new ResponseEntity<>(list,HttpStatus.OK);
             
    	   }catch(Exception e) {
    		   e.printStackTrace();
    		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    	   }
	
    	 
		
    	   
       }
       @GetMapping("/subject/list")
       public List<Subject> getsubject(){
    	   List<Subject> list= service.getsub();
		return list;
    	   
       }
       @GetMapping("/student/list/{id}")
       public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    
        	   System.out.println(id);
               Student student = service.getStudentById(id);
              
            
            	   System.out.println("student name "+student.getName());
                   return new ResponseEntity<>(student, HttpStatus.OK);
              
         
       }
}
