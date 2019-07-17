package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class PhoneEntity extends ProductEntity {

	private int ram;
	
	private int memory;
	
	private double screenSize;

	public PhoneEntity() {
	}
	
	
}
