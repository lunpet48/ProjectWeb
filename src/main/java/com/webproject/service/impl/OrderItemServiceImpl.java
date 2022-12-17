package com.webproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.OrderItem;
import com.webproject.repository.OrderItemRepo;
import com.webproject.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	private OrderItemRepo orderItemRepo;

	@Override
	public <S extends OrderItem> S save(S entity) {
		return orderItemRepo.save(entity);
	}

	public long count() {
		return orderItemRepo.count();
	}

	
}
