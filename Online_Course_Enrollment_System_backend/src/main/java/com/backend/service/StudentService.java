package com.backend.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.config.SecurityConfig;
import com.backend.dao.StudentDao;
import com.backend.model.Student;



@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	private final SecurityConfig securityConfig;
	
	public StudentService(SecurityConfig securityConfig) {
		this.securityConfig=securityConfig;
	}
	
	
	public Student saveStudentData(Student student) {
		student.setPassword(securityConfig.passwordEncoder().encode(student.getPassword()));
		if(studentDao.saveStudent(student)>0) {
			return student;
		}
		else {
			return null;
		}
	}
	
	public Student getStudentDetails(String email) {
			return studentDao.getStudnt(email);
	}
	
	
	public Student currentUser(String email) {
		Student student=studentDao.getStudnt(email);
		
		return student;
	}

}
