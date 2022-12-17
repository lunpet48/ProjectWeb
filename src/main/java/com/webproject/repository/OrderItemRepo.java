package com.webproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
<<<<<<< HEAD
	@Query(value="Select * from OrderItem where orderId=?", nativeQuery = true)
	List<OrderItem>findByOrderId(Long id);

=======
	@Query(value = "select * from OrderItem where orderId = ?1", nativeQuery = true)
	List<OrderItem> findByOrderId(Long id);
>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
}
