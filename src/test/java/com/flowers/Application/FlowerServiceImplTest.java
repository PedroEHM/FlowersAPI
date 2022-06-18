package com.flowers.Application;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.flowers.InventoryComponent.Application.FlowerServiceImpl;
import com.flowers.InventoryComponent.Domain.Flower;

class FlowerServiceImplTest {
	
	private FlowerServiceImpl flowerService;
	
	private ArrayList<Flower> initialFlowers = new ArrayList<Flower>(){{
		add(new Flower("1", "girasol", 15.00f));
		add(new Flower("2", "lirio", 14.5f));
		add(new Flower("3", "margarita", 25.30f));
		add(new Flower("4", "rosa", 20.9f));
		add(new Flower("5", "lirio", 19.87f));
	}};
	
	@Test
	void testSaveFlowers() {
		flowerService = new FlowerServiceImpl();
		String response = flowerService.saveFlowers(initialFlowers);
		
		Assertions.assertEquals("Guardado ok", response);
		Assertions.assertEquals(initialFlowers.toString(), FlowerServiceImpl.flowers.toString());		
	}
	
	@Test
	void testListFlowers() {
		flowerService = new FlowerServiceImpl();
		this.flowerService.saveFlowers(initialFlowers);
		ArrayList<Flower> listExpected = new ArrayList<Flower>();
		listExpected.add(new Flower("4", "rosa-kometsales", 20.9f));
		listExpected.add(new Flower("3", "margarita-kometsales", 25.30f));
		listExpected.add(new Flower("2", "lirio-kometsales", 14.5f));
		listExpected.add(new Flower("5", "lirio-kometsales", 19.87f));
		listExpected.add(new Flower("1", "girasol-kometsales", 15.00f));
		ArrayList<Flower> listReturned = this.flowerService.listSortedFlowers();
		Assertions.assertEquals(listExpected.toString(), listReturned.toString());
	}
	
	@Test
	void testListFlowersFilteredByPrice() {
		flowerService = new FlowerServiceImpl();
		this.flowerService.saveFlowers(initialFlowers);
		ArrayList<Flower> listExpected = new ArrayList<Flower>();
		listExpected.add(new Flower("3", "margarita", 25.30f));
		listExpected.add(new Flower("4", "rosa", 20.9f));
		ArrayList<Flower> listReturned = this.flowerService.listFlowersPriceFiltered();		
		Assertions.assertEquals(listExpected.toString(), listReturned.toString());		
	}
	
	@Test
	void testListFlowersFilteredByName() {
		flowerService = new FlowerServiceImpl();
		this.flowerService.saveFlowers(initialFlowers);
		ArrayList<Flower> listExpected = new ArrayList<Flower>();
		listExpected.add(new Flower("2", "lirio", 14.5f));
		listExpected.add(new Flower("5", "lirio", 19.87f));
		String testName = "lirio";
		ArrayList<Flower> listReturned = this.flowerService.listFlowersNameFiltered(testName);		
		Assertions.assertEquals(listExpected.toString(), listReturned.toString());		
	}
	
	@Test
	void testDeleteFlower() {
		flowerService = new FlowerServiceImpl();
		flowerService.saveFlowers(initialFlowers);
		
		ArrayList<Flower> listExpected = new ArrayList<Flower>();
		listExpected.add(new Flower("1", "girasol", 15.00f));
		listExpected.add(new Flower("2", "lirio", 14.5f));
		listExpected.add(new Flower("4", "rosa", 20.9f));		
		listExpected.add(new Flower("5", "lirio", 19.87f));
		
		String testId = "3";
		String response = flowerService.DeleteFlowerById(testId);
		ArrayList<Flower> listResulting = FlowerServiceImpl.flowers;
		Assertions.assertEquals("Flor eliminada", response);
		Assertions.assertEquals(listExpected.toString(), listResulting.toString());
		
		response = flowerService.DeleteFlowerById(testId);
		listResulting = FlowerServiceImpl.flowers;
		Assertions.assertEquals("No existe una flor con el id: [3]", response);
		Assertions.assertEquals(listExpected.toString(), listResulting.toString());
		
		
	}
}


