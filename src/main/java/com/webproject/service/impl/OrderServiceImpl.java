package com.webproject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<Order> findAll(int index, int pagenumber) {
		return orderRepo.findAll(PageRequest.of(index, pagenumber));
	}

	@Override
	public Page<Order> findByStatus(String status, int index, int pagenumber) {
		return orderRepo.findByStatus(status,PageRequest.of(index, pagenumber));
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepo.findById(id);
	}
	
	
}
