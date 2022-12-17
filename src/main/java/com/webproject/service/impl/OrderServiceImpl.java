package com.webproject.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Order> findAllByStoreId(Long id) {
		return orderRepo.findAllByStoreId(id);
	}

	@Override
	public long count() {
		return orderRepo.count();
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepo.findById(id);
	}
	
	
}
