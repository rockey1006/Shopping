package com.cart.communicaiton;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cart.to.CartItemTO;

@FeignClient("inventory-service")
@RequestMapping("/inventory")
public interface InventoryServiceCommunicator {

	@PostMapping("/update")
	public boolean updateInventoryItemAmount(@RequestBody CartItemTO cartItemTO);
	
	@PostMapping("/return")
	public boolean returnInventoryItem(@RequestBody CartItemTO cartItemTO);
}
