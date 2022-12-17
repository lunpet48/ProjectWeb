package com.webproject.service;

import java.util.List;
import java.util.Optional;

import com.webproject.entity.Order;

public interface OrderService {

	<S extends Order> S save(S entity);

	long count();

	List<Order> findAllByStoreId(Long id);

	Optional<Order> findById(Long id);

}
