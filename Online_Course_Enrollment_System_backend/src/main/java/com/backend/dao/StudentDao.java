package com.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.backend.model.Student;


@Repository
public interface StudentDao {
	
	int saveStudent(Student email);
	Student getStudnt(String email);
	List<Student> getAllStudent();
	void deleteStudent(String email);
	Student updateStudent();
	public Student currentUser(String email,String password);
	

}
