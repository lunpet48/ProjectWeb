package com.webproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	@Query(value = "Select * from Cart where userId=?1 and storeId = ?2", nativeQuery = true)
	Optional<Cart> findCartByUserIdAndStoreId(Long userId, Long storeId);
}
