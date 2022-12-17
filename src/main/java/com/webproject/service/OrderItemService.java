package com.webproject.service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c

import com.webproject.entity.OrderItem;

public interface OrderItemService {

	<S extends OrderItem> S save(S entity);
	
	List<OrderItem>findByOrderId(Long id);

	List<OrderItem> findByOrderId(Long id);

	long count();

}
