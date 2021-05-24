package disproject.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.Basket;
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
	
}
