package com.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.backend.model.Course;


@Repository
public interface CourceDao {
	List<Course> getAllCources();
	Course addCource(Course course);

}
