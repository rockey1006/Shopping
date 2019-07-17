package com.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.entity.PhoneEntity;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {

}
