package com.webproject.service;

import java.util.Optional;

import com.webproject.entity.Cart;
import com.webproject.entity.CartItem;

public interface CartItemService {

	<S extends CartItem> S save(S entity);

	Optional<CartItem> findCartItemByCartIdAndProductId(Long cartId, Long productId);

	void updateCartItem(int count, Long cartId, Long productId) throws Exception;

}
