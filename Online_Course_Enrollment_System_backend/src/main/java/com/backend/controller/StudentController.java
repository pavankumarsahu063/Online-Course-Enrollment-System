package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Student;
import com.backend.service.StudentService;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		
		if(studentService.saveStudentData(student)!=null) {
		return ResponseEntity.ok("User registered successfully!");}
		
		else {
		return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering student");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginStudent(){
		return null;
	}
	
	@GetMapping("/allstudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllstudents());
	}
}
