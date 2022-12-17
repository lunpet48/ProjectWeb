package com.webproject.service;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.domain.Page;

=======
import java.util.List;
import java.util.Optional;

>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
import com.webproject.entity.Order;

public interface OrderService {

	<S extends Order> S save(S entity);
<<<<<<< HEAD
	
	Page<Order>findAll(int index,int pagenumber);
	
	Page<Order>findByStatus(String status,int index,int pagenumber);
	
	Optional<Order> findById(Long id);
=======

	long count();

	List<Order> findAllByStoreId(Long id);

	Optional<Order> findById(Long id);

>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
}
