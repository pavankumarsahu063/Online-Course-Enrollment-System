package com.backend.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.backend.dao.StudentDaoImpl;
import com.backend.model.CustomeUserDetails;
import com.backend.model.Student;


@Service
public class CustomeUserDetailsService implements UserDetailsService{
	
	private final StudentDaoImpl studentDaoImpl;
	
	public CustomeUserDetailsService(StudentDaoImpl studentDaoImpl) {
		this.studentDaoImpl=studentDaoImpl;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Student student=studentDaoImpl.getStudnt(username);
		System.out.println("userDetailService"+student);
		if(student==null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomeUserDetails(student);
	}

}
