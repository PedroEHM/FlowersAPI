package com.flowers.InventoryComponent.Domain;

public class Flower {
	private String id;
	private String name;
	private float price;
	
	public Flower(String id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	/**
	 * Returns a deep copy of the current flower 
	 */
	public Flower copy() {
		return new Flower(this.id, this.name, this.price);
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
