package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.ProductEntity;
import com.product.enums.Category;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByModel(String model);

	List<ProductEntity> findByCategory(Category category);

}
