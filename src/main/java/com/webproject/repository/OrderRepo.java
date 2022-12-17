package com.webproject.repository;

<<<<<<< HEAD
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
=======
import java.util.List;

>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
<<<<<<< HEAD
	@Query(value = "SELECT * FROM orders where status=?", nativeQuery = true)
	Page<Order> findByStatus(String status, PageRequest of);
=======
	@Query(value = "Select * from Orders where storeId=?1", nativeQuery = true)
	List<Order> findAllByStoreId(Long id);
>>>>>>> 382c9a5ac843801b3c1a03f9db6f4bf37abb898c
}
