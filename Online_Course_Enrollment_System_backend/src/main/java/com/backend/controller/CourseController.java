package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Course;
import com.backend.service.CourceService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {
	
	@Autowired
	private CourceService courceService;
	
	
	@GetMapping("/allcourses")
	public ResponseEntity<List<Course>> displayAllCourses(){
		
		return ResponseEntity.ok(courceService.getCourses());
	}
	@PostMapping("/buy")
	public ResponseEntity<String> buycource(@RequestBody Course course){
		return null;
	}

}
