package com.webproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
	@Query(value = "select * from OrderItem where orderId = ?1", nativeQuery = true)
	List<OrderItem> findByOrderId(Long id);
}
