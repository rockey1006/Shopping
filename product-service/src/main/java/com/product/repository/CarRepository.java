package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Long> {

	List<CarEntity> findByModel(String model);

}
