package com.webproject.service;

import java.sql.Date;
import java.util.List;

import com.webproject.entity.User;

public interface UserService {
	
	List<User>findAll();
	
	long Count();
	
	List<User>newUsers();
	
	int countByDate(Date date);

	<S extends User> S save(S entity);

	User findByEmail(String email);
	
}
