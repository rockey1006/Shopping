package com.cart.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cart.to.CartItemTO;

@Entity
@Table(name = "cart")
public class CartItemEntity {

	@Id
	@GeneratedValue
	private Long id;

	private Long productId;
	
	private int amount;

	public CartItemEntity() {
	}
	
	public CartItemEntity(CartItemTO cartItemTO) {
		this.productId = cartItemTO.getProductId();
		this.amount = cartItemTO.getAmount();
	}

	public Long getId() {
		return id;
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
