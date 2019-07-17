package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.service.InventoryService;
import com.inventory.to.InventoryItemTO;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/update")
	public boolean updateInventoryItemAmount(@RequestBody InventoryItemTO inventoryItemTO) {
		return inventoryService.updateInventoryItemAmount(inventoryItemTO);
	}
	
	@PostMapping("/return")
	public boolean returnInventoryItem(@RequestBody InventoryItemTO inventoryItemTO) {
		return inventoryService.returnInventoryItem(inventoryItemTO);
	}
	
	@GetMapping("/available/{productId}")
	boolean isProductAvailable(@PathVariable Long productId) {
		return inventoryService.isProductAvailable(productId);
	}
}
