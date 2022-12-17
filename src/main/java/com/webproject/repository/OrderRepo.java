package com.webproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
	@Query(value = "SELECT * FROM orders where status=?", nativeQuery = true)
	Page<Order> findByStatus(String status, PageRequest of);
}
