package com.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
	
}
