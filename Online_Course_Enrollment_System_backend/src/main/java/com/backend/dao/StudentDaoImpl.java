package com.backend.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.backend.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@Override
	public int saveStudent(Student student) {
		
		String insertStudent="INSERT INTO users (name,email,phone,password) VALUES(?,?,?,?)";
		
		return jdbcTemplate.update(insertStudent, student.getName(),student.getEmail(),student.getPhone(),student.getPassword());
	}

	@Override
	public List<Student> getAllStudent() {
		String selectStudents="SELECT * FROM users";
		
		return jdbcTemplate.query(selectStudents, (rs,rowNum)->{
			  Student student = new Student();
	            student.setName(rs.getString("name"));
	            student.setEmail(rs.getString("email"));
	            student.setPhone(rs.getString("phone"));
	            student.setPassword(rs.getString("password"));
	            return student;
		});
	}

	@Override
	public void deleteStudent(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student updateStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudnt(String email) {
		String sql="SELECT * FROM users WHERE email=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		return jdbcTemplate.queryForObject(sql, rowMapper,email);
	}

	@Override
	public Student currentUser(String email,String password) {
		String sql="SELECT * FROM users WHERE email=? AND password=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		return jdbcTemplate.queryForObject(sql,rowMapper,email,password);
	}
	


	
	



}
