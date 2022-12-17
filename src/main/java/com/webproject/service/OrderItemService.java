package com.webproject.service;

import com.webproject.entity.OrderItem;

public interface OrderItemService {

	<S extends OrderItem> S save(S entity);

}
