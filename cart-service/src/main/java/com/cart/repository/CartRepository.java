package com.cart.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.entity.CartItemEntity;

@Transactional
public interface CartRepository extends JpaRepository<CartItemEntity, Long> {

	void deleteByProductId(Long productId);

	CartItemEntity findByProductId(Long productId);
}
