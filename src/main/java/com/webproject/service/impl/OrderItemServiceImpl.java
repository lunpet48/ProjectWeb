package com.webproject.service.impl;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c

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

	@Override
<<<<<<< HEAD
=======
	public long count() {
		return orderItemRepo.count();
	}

	@Override
>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
	public List<OrderItem> findByOrderId(Long id) {
		return orderItemRepo.findByOrderId(id);
	}

	
}
