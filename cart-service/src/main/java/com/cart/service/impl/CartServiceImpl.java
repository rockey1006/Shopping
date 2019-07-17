package com.cart.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cart.communicaiton.InventoryServiceCommunicator;
import com.cart.communicaiton.ProductServiceCommunicator;
import com.cart.entity.CartItemEntity;
import com.cart.repository.CartRepository;
import com.cart.service.CartService;
import com.cart.to.CartItemTO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductServiceCommunicator productServiceCommunicator;
	
	@Autowired
	private InventoryServiceCommunicator inventoryServiceCommunicator;
	
	@Override
	public ResponseEntity<String> addToCart(CartItemTO cartItemTO) {
		if(!productServiceCommunicator.isProductWithIdExist(cartItemTO.getProductId())) {
			return new ResponseEntity<>("Product with id: " + cartItemTO.getProductId() + " does not exist", HttpStatus.NOT_FOUND);
		}
		if(!inventoryServiceCommunicator.updateInventoryItemAmount(cartItemTO)) {
			return new ResponseEntity<>("There is no enough products in database", HttpStatus.CONFLICT);
		}
		
		CartItemEntity cartItem = cartRepository.findByProductId(cartItemTO.getProductId());
		
		if(cartItem != null) {
			cartItem.setAmount(cartItem.getAmount() + cartItemTO.getAmount());
			cartRepository.save(cartItem); // check if without works
		} else {
			cartRepository.save(new CartItemEntity(cartItemTO));
		}

		return new ResponseEntity<>("Product added to cart", HttpStatus.CREATED);
	}

	@Override
	public void deleteFromCart(CartItemTO cartItemTO) {
		inventoryServiceCommunicator.returnInventoryItem(cartItemTO);
		
		CartItemEntity cartItem = cartRepository.findByProductId(cartItemTO.getProductId());
		if(cartItem.getAmount() == cartItemTO.getAmount()) {
			cartRepository.deleteByProductId(cartItemTO.getProductId());
		} else {
			cartItem.setAmount(cartItem.getAmount() - cartItemTO.getAmount());
			cartRepository.save(cartItem);
		}

	}

	@Override
	public List<CartItemTO> getCartItems() {
		return cartRepository.findAll()
							 .stream()
							 .map(cartItem -> new CartItemTO(cartItem))
							 .collect(Collectors.toList());
	}
}
