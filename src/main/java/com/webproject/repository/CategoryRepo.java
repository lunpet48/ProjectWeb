package com.webproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webproject.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
	
	Category findBySlug(String slug);
}
