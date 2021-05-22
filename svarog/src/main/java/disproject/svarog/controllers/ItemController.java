package disproject.svarog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.svarog.models.Item;
import disproject.svarog.repositories.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("/items")
	public List<Item> getAllItems(){
		
		return itemRepo.findAll();
		
	}
	
}
