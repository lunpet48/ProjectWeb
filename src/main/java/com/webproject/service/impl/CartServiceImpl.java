package com.webproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webproject.entity.Cart;
import com.webproject.repository.CartRepo;
import com.webproject.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepo cartRepo;

	@Override
	public Optional<Cart> findCartByUserIdAndStoreId(Long userId, Long storeId) {
		return cartRepo.findCartByUserIdAndStoreId(userId, storeId);
	}

	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepo.save(entity);
	}
	
}
