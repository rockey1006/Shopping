package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.ProductService;
import com.product.to.ProductTO;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins ="http://localhost:4200", allowedHeaders= "*")
public class ProductController {

	@Autowired
	ProductService<ProductTO> productService;
	
	@GetMapping("/check/{id}")
	public boolean isProductWithIdExist(@PathVariable Long id) {
		return productService.findById(id).getId() != null;
	}
	
	
	//ogarnąć metodę getcategory
	//wyswietlenie produktów w angularze
	//dodanie koszyka w angularze
	//usuwanie z koszyka w angularze
	@GetMapping("/category/{category}")
	public List<ProductTO> getByCategory(@PathVariable String category) {
		
		List<ProductTO> products = productService.findByCategory(category);
		
		return products;
	}

}
