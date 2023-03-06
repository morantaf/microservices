package com.microservice.inventoryservice;

import com.microservice.inventoryservice.model.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
		Inventory iPhone = new Inventory();
		iPhone.setSkuCode("iphone_13");
		iPhone.setQuantity(100);

		Inventory iPhoneRed = new Inventory();
		iPhoneRed.setSkuCode("iphone_13_red");
		iPhoneRed.setQuantity(0);

		inventoryRepository.save(iPhone);
		inventoryRepository.save(iPhoneRed);
		};
	}

}
