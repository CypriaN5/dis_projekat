package disproject.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.Basket;
import disproject.perun.models.Item;
import disproject.perun.repositories.BasketRepository;

@RestController
public class BasketController {

	@Autowired
	private BasketRepository basketRepo;
	
	
	@GetMapping("/baskets")
	public ResponseEntity<Object> getAllBaskets() {
		List<Basket> baskets = basketRepo.findAll();
		
		if (!baskets.isEmpty()) {
			return new ResponseEntity<>(baskets, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoBasketsFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/baskets/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Basket> basket = basketRepo.findById(id);
		
		if (!basket.isPresent()) {
			return new ResponseEntity<>("BasketNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(basket, HttpStatus.OK);
	}
	
	@PostMapping("/basket")
	public ResponseEntity<Object> addBasket(@RequestBody Basket basket) {
		
		//TODO implement fetching items from svarog and then create a basket
		
		basket.setClosed(false);
		basket.setPaymentRefId("BEDTEST");
		
		List<Item> items = basket.getItems();
		
		basket.setTotalPrice(0);
		for (Item item : items) {
			basket.setTotalPrice(basket.getTotalPrice() + item.getTotalPrice());
		}
		
		basket.setCreatedAt(LocalDateTime.now());
		basket.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(basketRepo.save(basket), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/basket/{id}")
	public ResponseEntity<Object> updateBasket(@PathVariable UUID id, @RequestBody Basket basketTemp) {
		
		Optional<Basket> basketOptional = basketRepo.findById(id);
		
		if (!basketOptional.isPresent()) {
			return new ResponseEntity<>("BasketNotFound", HttpStatus.NOT_FOUND);
		}
		
		Basket basket = basketOptional.get();
		
		List<Item> newItems = basketTemp.getItems();
		
		basket.setItems(basketTemp.getItems());
		
		basket.setTotalPrice(0);
		for (Item item : newItems) {
			basket.setTotalPrice(basket.getTotalPrice() + item.getTotalPrice());
		}
		
		basket.setStoreId(basketTemp.getStoreId());
		
		basket.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(basketRepo.save(basket), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
