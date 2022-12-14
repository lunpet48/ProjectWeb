package com.webproject.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.User;
import com.webproject.repository.UserRepo;
import com.webproject.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public long Count() {
		// TODO Auto-generated method stub
		return userRepo.count();
	}

	@Override
	public List<User> newUsers() {
		// TODO Auto-generated method stub
		return userRepo.users();
	}

	@Override
	public int countByDate(Date date) {
		// TODO Auto-generated method stub
		return userRepo.countByDate(date);
	}

	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		List<User> users = userServiceImpl.findAll();
		for (User user : users) {
			System.out.println(user.getEmail());
		}
	}
}
