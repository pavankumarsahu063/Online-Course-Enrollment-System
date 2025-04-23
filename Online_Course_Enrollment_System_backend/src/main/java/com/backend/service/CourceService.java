package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dao.CourceDao;
import com.backend.model.Course;

@Service
public class CourceService {
	@Autowired
	private CourceDao courceDa;
	
	public List<Course> getCourses(){
		return courceDa.getAllCources();
	}
	

}
