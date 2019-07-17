package com.cart.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cart.entity.CartItemEntity;

public class CartItemTO {

	@NotNull
	@NotEmpty
	private Long productId;
	
	@NotNull
	@NotEmpty
	private int amount;
	
	public CartItemTO(CartItemEntity cartItemEntity) {
		this.productId = cartItemEntity.getProductId();
		this.amount = cartItemEntity.getAmount();
	}
	
	public CartItemTO() {}
	
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
