package com.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.backend.model.Course;

@Repository
public class CourseDaoImple implements CourceDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Course> getAllCources() {
		// TODO Auto-generated method stub
		String query="SELECT * FROM course";
		return jdbcTemplate.query(query, (rs,rowNum)->{
			 Course course = new Course();
		        course.setId(rs.getInt("id"));
		        course.setTitle(rs.getString("title"));
		        course.setDescription(rs.getString("description"));
		        course.setInstructor(rs.getString("instructor"));
		        course.setDuration(rs.getString("duration"));
		        course.setCategory(rs.getString("category"));
		        course.setImageUrl(rs.getString("image_url"));
		        return course;
			
		});
	}

	@Override
	public Course addCource(Course course) {
		String sql="INSERT INTO cart (user_id,course_id) VALUES(?,?)";
		
		return null;
	}

}
