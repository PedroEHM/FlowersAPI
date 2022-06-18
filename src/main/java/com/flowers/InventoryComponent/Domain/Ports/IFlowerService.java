package com.flowers.InventoryComponent.Domain.Ports;

import java.util.ArrayList;

import com.flowers.InventoryComponent.Domain.Flower;

/**
 * IFlowerService is an interface to be implemented in application layer  
 */
public interface IFlowerService {
	/**
	 * Saves the flowers'array in memory  
	 * Returns the result message
	 */
	public String saveFlowers(ArrayList<Flower> flowers);
	
	/**
	 * Lists the flowers sorted descending by name, and at the end of every name concatenates the string '-kometsales'  
	 */
	public ArrayList<Flower> listSortedFlowers();
	
	/**
	 * Lists the flowers which the price be greater than 20
	 */
	public ArrayList<Flower> listFlowersPriceFiltered();
	
	/**
	 * Lists the flowers which the name be equal to the name parameter
	 */
	public ArrayList<Flower> listFlowersNameFiltered(String name);
	
	/**
	 * Deletes the flower which id be equal to id parameter
	 * Returns the result message
	 */
	public String DeleteFlowerById(String id);
}
