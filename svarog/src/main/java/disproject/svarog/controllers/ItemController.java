package disproject.svarog.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import disproject.svarog.models.Item;
import disproject.svarog.repositories.ItemRepository;

@RestController
public class ItemController {

	@Autowired
	private ItemRepository itemRepo;
	
	@GetMapping("/items")
	public ResponseEntity<Object> getAllItems() {
		List<Item> items = itemRepo.findAll();
		
		if (!items.isEmpty()) {
			return new ResponseEntity<>(items, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoItemsFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Item> item = itemRepo.findById(id);
		
		if (!item.isPresent()) {
			return new ResponseEntity<>("ItemNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	//POSTPONED, 
	/*
	 * @PostMapping("/item") public ResponseEntity<Object> addItem(@RequestBody Item
	 * item){
	 * 
	 * try { return new ResponseEntity<>(itemRepo.save(item), HttpStatus.OK) ; }
	 * catch (Exception e) { return new ResponseEntity<>(e.getLocalizedMessage(),
	 * HttpStatus.BAD_REQUEST); } }
	 */

	
}
