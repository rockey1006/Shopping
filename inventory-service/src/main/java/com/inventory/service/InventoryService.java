package com.inventory.service;

import com.inventory.to.InventoryItemTO;

public interface InventoryService {

	boolean updateInventoryItemAmount(InventoryItemTO inventoryItemTO);
	
	boolean returnInventoryItem(InventoryItemTO inventoryItemTO);
	
	boolean isProductAvailable(Long productId);
}
