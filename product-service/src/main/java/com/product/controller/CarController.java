package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.exceptions.WrongProductIdException;
import com.product.service.ProductService;
import com.product.to.CarTO;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	ProductService<CarTO> carService;
	
	@GetMapping("/all")
	public List<CarTO> getAll() {
		return carService.findAll();
	}
	
	@GetMapping("/all/available")
	public List<CarTO> getAllAvailableCars() {
		return carService.getAllAvailable();
	}
	
	@GetMapping("/model/{model}")
	public List<CarTO> getByModel(@PathVariable String model) {
		return carService.findByModel(model);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarTO> getById(@PathVariable Long id) throws WrongProductIdException {
		
		CarTO car = carService.findById(id);
		
		if(car.getId() != null) {
			return new ResponseEntity<CarTO>(car, HttpStatus.OK); 
		}
		
		return new ResponseEntity<CarTO>(HttpStatus.NOT_FOUND);  
	}
}
