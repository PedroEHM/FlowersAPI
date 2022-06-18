package com.flowers.InventoryComponent.Infrastructure.Inbound.Rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flowers.InventoryComponent.Domain.Flower;
import com.flowers.InventoryComponent.Domain.Ports.IFlowerService;
import com.flowers.InventoryComponent.Infrastructure.Inbound.DTO.FlowerDTO;
import com.flowers.InventoryComponent.Infrastructure.Inbound.DTO.FlowerMapper;

@RestController
@RequestMapping("api/flowers")
public class Controller {
	
	@Autowired
	@Qualifier("serviceImpl1")
	private IFlowerService flowerService;
	
	@Autowired
	private FlowerMapper flowerMapper;
	
	@PostMapping()
	public String save(@RequestBody ArrayList<Flower> flowers) {
		return this.flowerService.saveFlowers(flowers);
	}
	
	@GetMapping()
	private ArrayList<FlowerDTO> listAll() {
		ArrayList<Flower> flowers = this.flowerService.listSortedFlowers();
		return this.flowerMapper.flowersToFlowerDTOs(flowers);
	}
	
	@GetMapping("/filter/price")
	private ArrayList<Flower> listFilteredByPrice() {
		return this.flowerService.listFlowersPriceFiltered();
	}
	
	@GetMapping("/filter/name/{name}")
	private ArrayList<Flower> listFilteredByName(@PathVariable("name") String name) {
		return this.flowerService.listFlowersNameFiltered(name);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable("id") String id) {
		return this.flowerService.DeleteFlowerById(id);
	}
	
}
