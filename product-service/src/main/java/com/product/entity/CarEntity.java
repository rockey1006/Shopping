package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.product.enums.Category;

@Entity
@Table(name = "cars")
public class CarEntity extends ProductEntity {

	private double maxSpeed;

	private int nrOfSeats;

	public CarEntity() {
	}

	public CarEntity(String picture, double price, Category category, String brand, String model, double weight, double maxSpeed,
			int nrOfSeats) {
		super(picture, price, category, brand, model, weight);
		this.maxSpeed = maxSpeed;
		this.nrOfSeats = nrOfSeats;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public int getNrOfSeats() {
		return nrOfSeats;
	}

	public void setNrOfSeats(int nrOfSeats) {
		this.nrOfSeats = nrOfSeats;
	}

	@Override
	public String toString() {
		return "CarEntity [maxSpeed=" + maxSpeed + ", nrOfSeats=" + nrOfSeats + ", getId()=" + getId() + ", getPrice()="
				+ getPrice() + ", getCategory()=" + getCategory() + ", getBrand()=" + getBrand() + ", getModel()="
				+ getModel() + ", getWeight()=" + getWeight() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
