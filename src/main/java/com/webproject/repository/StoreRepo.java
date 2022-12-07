package com.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
	@Query(value = "Select * from Stores where ownerId = ?", nativeQuery = true)
	Store findByOwnerId(Long ownerId);
}
