package com.product.to;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.product.entity.CarEntity;

public class CarTO extends ProductTO {

	@NotNull
	@NotEmpty
	private double maxSpeed;

	@NotNull
	@NotEmpty
	private int nrOfSeats;
	
	public CarTO(CarEntity carEntity) {
		super(carEntity.getPicture(), carEntity.getId(),carEntity.getPrice(), carEntity.getCategory(), carEntity.getBrand(), carEntity.getModel(), carEntity.getWeight());
		this.maxSpeed = carEntity.getMaxSpeed();
		this.nrOfSeats = carEntity.getNrOfSeats();
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
	
	

}
