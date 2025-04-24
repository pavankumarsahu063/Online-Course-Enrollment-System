package com.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Student;
import com.backend.service.StudentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		
		if(studentService.saveStudentData(student)!=null) {
		return ResponseEntity.ok("User registered successfully!");}
		
		else {
		return	ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering student");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginStudent(@RequestBody Student student,HttpSession session){
		
		System.out.println(student.getEmail());
		System.out.println(student.getPassword());
		
		Student currentUserStudent=studentService.currentUser(student.getEmail(),passwordEncoder.encode(student.getPassword()));
		session.setAttribute("student", currentUserStudent);
		Authentication authentication=authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(student.getEmail(), student.getPassword())
				);
		
		return ResponseEntity.ok("Login");
	}
	
	@GetMapping("/currentuser")
	public ResponseEntity<Student> getCurrentUsername(HttpSession session) {
		Student currentUser=(Student) session.getAttribute("student");
	    System.out.println(currentUser.getEmail());
	    return ResponseEntity.ok(studentService.getStudentDetails(currentUser.getEmail()));
	}

}
