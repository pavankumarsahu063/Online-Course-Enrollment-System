package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.StudentDao;
import com.backend.model.Student;



@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	
	public Student saveStudentData(Student student) {
		if(studentDao.saveStudent(student)>0) {
			return student;
		}
		else {
			return null;
		}
	}
	
	public List<Student> getAllstudents(){
		return studentDao.getAllStudent();
	}

}
