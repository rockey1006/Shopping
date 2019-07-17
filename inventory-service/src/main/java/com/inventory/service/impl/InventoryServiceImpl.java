package com.inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.InventoryItemEntity;
import com.inventory.repository.InventoryRepository;
import com.inventory.service.InventoryService;
import com.inventory.to.InventoryItemTO;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public boolean updateInventoryItemAmount(InventoryItemTO inventoryItemTO) {
		InventoryItemEntity inventoryEntity = inventoryRepository.findByProductId(inventoryItemTO.getProductId());

		if (inventoryItemTO.getAmount() > inventoryEntity.getAmount()) {
			return false;
		}
		inventoryEntity.setAmount(inventoryEntity.getAmount() - inventoryItemTO.getAmount());
		inventoryRepository.save(inventoryEntity);

		return true;
	}

	@Override
	public boolean returnInventoryItem(InventoryItemTO inventoryItemTO) {
		InventoryItemEntity inventoryEntity = inventoryRepository.findByProductId(inventoryItemTO.getProductId());
		inventoryEntity.setAmount(inventoryEntity.getAmount() + inventoryItemTO.getAmount());
		inventoryRepository.save(inventoryEntity);
		
		return true;
	}

	@Override
	public boolean isProductAvailable(Long productId) {
		return inventoryRepository.findByProductId(productId).getAmount() > 0;
	}

}
