package com.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.service.CartService;
import com.cart.to.CartItemTO;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins ="http://localhost:4200", allowedHeaders= "*")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/add")
	public ResponseEntity<String> addToCart(@RequestBody CartItemTO cartItemTO) {
		return cartService.addToCart(cartItemTO);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFromCart(@RequestBody CartItemTO cartItemTO) {
		cartService.deleteFromCart(cartItemTO);
		return new ResponseEntity<>("Product deleted from cart", HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<CartItemTO> getCartItems() {
		return cartService.getCartItems();
	}
}
