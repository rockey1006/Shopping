package com.inventory.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inventory.entity.InventoryItemEntity;

public class InventoryItemTO {

	@NotNull
	@NotEmpty
	private Long productId;
	
	@NotNull
	@NotEmpty
	private int amount;
	
	public InventoryItemTO(InventoryItemEntity inventoryItemEntity) {
		this.productId = inventoryItemEntity.getProductId();
		this.amount = inventoryItemEntity.getAmount();
	}
	
	public InventoryItemTO() {
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
