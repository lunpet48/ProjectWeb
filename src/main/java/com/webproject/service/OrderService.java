package com.webproject.service;

import com.webproject.entity.Order;

public interface OrderService {

	<S extends Order> S save(S entity);

}
