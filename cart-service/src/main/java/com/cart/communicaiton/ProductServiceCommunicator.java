package com.cart.communicaiton;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("product-service")
@RequestMapping("/products")
public interface ProductServiceCommunicator {

	@GetMapping("/check/{id}")
	public boolean isProductWithIdExist(@PathVariable Long id);
}
