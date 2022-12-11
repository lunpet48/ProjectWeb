package com.webproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.webproject.entity.Product;
import com.webproject.repository.ProductRepo;
import com.webproject.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	@Override
	public <S extends Product> S save(S entity) {
		return productRepo.save(entity);
	}

	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepo.findAll(pageable);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productRepo.findAll(sort);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findAllByStoreId(Long storeId) {
		return productRepo.findAllByStoreId(storeId);
	}
	
	
}
