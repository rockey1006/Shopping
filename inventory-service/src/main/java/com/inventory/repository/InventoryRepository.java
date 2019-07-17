package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.entity.InventoryItemEntity;

public interface InventoryRepository extends JpaRepository<InventoryItemEntity, Long> {

	InventoryItemEntity findByProductId(Long productId);

}
