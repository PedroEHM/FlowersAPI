package com.flowers.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.flowers.InventoryComponent.Domain.Flower;

class FlowerTest {

	@Test
	void testFlowerCopy() {
		Flower flower = new Flower("1", "rosa", 20.5f);
		Flower flowerCopy = flower.copy();
		Assertions.assertFalse(flower.equals(flowerCopy));
	}
	
}
