package com.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.backend.model.Student;

public class RowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student=new Student();
		student.setName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		student.setPassword(rs.getString("password"));
		student.setPhone(rs.getString("phone"));
		return student;
	}

}
