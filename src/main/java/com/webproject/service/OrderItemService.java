package com.webproject.service;

import java.util.List;
import java.util.Optional;

import com.webproject.entity.OrderItem;

public interface OrderItemService {

	<S extends OrderItem> S save(S entity);
	
	List<OrderItem>findByOrderId(Long id);

}
