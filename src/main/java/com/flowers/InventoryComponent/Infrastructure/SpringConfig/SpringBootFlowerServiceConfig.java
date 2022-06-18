package com.flowers.InventoryComponent.Infrastructure.SpringConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flowers.InventoryComponent.Application.FlowerServiceImpl;
import com.flowers.InventoryComponent.Domain.Ports.IFlowerService;

@Configuration
public class SpringBootFlowerServiceConfig {
	@Bean
	@Qualifier("serviceImpl1")
	public IFlowerService flowerService() {
	  return new FlowerServiceImpl();
	}
}
