package com.cart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cart.to.CartItemTO;

public interface CartService {

	ResponseEntity<String> addToCart(CartItemTO cartItemTO);
	
	List<CartItemTO> getCartItems();
	
	void deleteFromCart(CartItemTO cartItemTO);
}
