package com.flowers.InventoryComponent.Infrastructure.Inbound.DTO;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.flowers.InventoryComponent.Domain.Flower;

@Component
public class FlowerMapper {
	
	/**
	 * Returns an ArrayList<FlowerDTO> from an ArrayList<Flower>
	 * */
	public ArrayList<FlowerDTO> flowersToFlowerDTOs(ArrayList<Flower> flowers){
		ArrayList<FlowerDTO> dtos = new ArrayList<FlowerDTO>();
		flowers.forEach(flower -> {
			dtos.add(new FlowerDTO(flower.getName(), flower.getPrice()));
		});
		return dtos;
	}

}
