package com.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.backend.model.Student;


@Repository
public interface StudentDao {
	
	int saveStudent(Student student);
	Student getStudnt(Student student);
	List<Student> getAllStudent();
	void deleteStudent(String email);
	Student updateStudent();

}
