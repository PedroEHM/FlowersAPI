package com.flowers.InventoryComponent.Infrastructure.Inbound.DTO;

public class FlowerDTO {
	public String name;
	public float price;
	
	public FlowerDTO(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

}
