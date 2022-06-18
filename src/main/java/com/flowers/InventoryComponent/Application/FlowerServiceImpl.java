package com.flowers.InventoryComponent.Application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.flowers.InventoryComponent.Domain.Flower;
import com.flowers.InventoryComponent.Domain.Ports.IFlowerService;

public class FlowerServiceImpl implements IFlowerService {
	
	public static ArrayList<Flower> flowers;	
	public HashMap<String, Flower> flowersMap;
	
	public FlowerServiceImpl() {
		FlowerServiceImpl.flowers = new ArrayList<Flower>();
	}
	
	@Override
	public String saveFlowers(ArrayList<Flower> flowers) {
		FlowerServiceImpl.flowers = flowers;
		this.flowersMap = new HashMap<String, Flower>();
		FlowerServiceImpl.flowers.forEach(flower -> {
			flowersMap.put(flower.getId(), flower);
		});
		return "Guardado ok";
	}

	@Override
	public ArrayList<Flower> listSortedFlowers() {
		ArrayList<Flower> flowersCopy = new ArrayList<Flower>();
		FlowerServiceImpl.flowers.forEach((flower) -> {
			Flower flowerCopy = flower.copy();
			flowerCopy.setName(flowerCopy.getName() + "-kometsales");
			flowersCopy.add(flowerCopy);
		});
		Collections.sort(flowersCopy, new Comparator<Flower>() {
		    @Override
		    public int compare(Flower f1, Flower f2) {
		        return f2.getName().compareTo(f1.getName());
		    }
		});
		return flowersCopy;
	}

	@Override
	public ArrayList<Flower> listFlowersPriceFiltered() {
		Predicate<Flower> predicate = flower -> flower.getPrice() > 20;
		ArrayList<Flower> filteredFlowers = (ArrayList<Flower>) FlowerServiceImpl.flowers.stream().filter(predicate).collect(Collectors.toList());
		return filteredFlowers;
	}

	@Override
	public ArrayList<Flower> listFlowersNameFiltered(String name) {
		Predicate<Flower> predicate = flower -> flower.getName().equals(name);
		ArrayList<Flower> filteredFlowers = (ArrayList<Flower>) FlowerServiceImpl.flowers.stream().filter(predicate).collect(Collectors.toList());
		return filteredFlowers;
	}

	@Override
	public String DeleteFlowerById(String id) {
		if(this.flowersMap.containsKey(id)) {
			Flower flower = this.flowersMap.get(id);
			FlowerServiceImpl.flowers.remove(flower);
			this.flowersMap.remove(id);
			return "Flor eliminada";
		} else {
			return "No existe una flor con el id: [" + id + "]";
		}
		
	}

}
