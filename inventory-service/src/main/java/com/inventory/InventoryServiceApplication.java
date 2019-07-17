package com.inventory;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.inventory.entity.InventoryItemEntity;
import com.inventory.repository.InventoryRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		inventoryRepository.save(new InventoryItemEntity(Long.valueOf(1),22));
		inventoryRepository.save(new InventoryItemEntity(Long.valueOf(2),213));
		inventoryRepository.save(new InventoryItemEntity(Long.valueOf(3),1));
		inventoryRepository.save(new InventoryItemEntity(Long.valueOf(4),0));
		
	}
}
