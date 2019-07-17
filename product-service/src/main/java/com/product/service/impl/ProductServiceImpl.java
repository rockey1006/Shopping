package com.product.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.communication.InventoryServiceCommunicator;
import com.product.entity.ProductEntity;
import com.product.enums.Category;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import com.product.to.ProductTO;

@Service
public class ProductServiceImpl implements ProductService<ProductTO> {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private InventoryServiceCommunicator inventoryServiceCommunicator;
	
	@Override
	public List<ProductTO> findAll() {
		
		List<ProductEntity> productEntities = productRepository.findAll();
		
		return productEntities.stream()
						   .map(product -> new ProductTO(product))
						   .collect(Collectors.toList());
	}

	@Override
	public List<ProductTO> findByModel(String model) {
		List<ProductEntity> productEntities = productRepository.findByModel(model);
		
		return productEntities.stream()
						   .map(product -> new ProductTO(product))
						   .collect(Collectors.toList());
	}

	@Override
	public ProductTO findById(Long id) {
		ProductEntity product = productRepository.findById(id).orElse(new ProductEntity());
		
		return new ProductTO(product);
	}

	@Override
	public List<ProductTO> getAllAvailable() {
		List<ProductEntity> productEntities = productRepository.findAll();
		
		return productEntities.stream()
						   .map(product -> new ProductTO(product))
						   .filter(productTO -> inventoryServiceCommunicator.isProductAvailable(productTO.getId()))
						   .collect(Collectors.toList());
	}

	@Override
	public List<ProductTO> findByCategory(String category) {
		List<ProductEntity> productsEntities = productRepository.findByCategory(mapCategoryToEnum(category));
		
		return productsEntities.stream()
							   .map(productEntity -> new ProductTO(productEntity))
							   .collect(Collectors.toList());
	}
	
	private Category mapCategoryToEnum(String category) {
		for(Category categoryEnum : Category.values()) {
			if(categoryEnum.toString().equals(category)) {
				return categoryEnum;
			}
		}
		return null; // co w takiej sytuacji
	}

}
