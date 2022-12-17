package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Order;
import com.webproject.repository.OrderRepo;
import com.webproject.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;

	@Override
	public <S extends Order> S save(S entity) {
		return orderRepo.save(entity);
	}
	
	
}
