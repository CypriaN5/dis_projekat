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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.Store;
import disproject.perun.repositories.StoreRepository;

@RestController
public class StoreController {

	@Autowired
	private StoreRepository storeRepo;
	
	@GetMapping("/stores")
	public ResponseEntity<Object> getAllStores() {
		List<Store> stores = storeRepo.findByIsDeleted(false);
		
		if (!stores.isEmpty()) {
			return new ResponseEntity<>(stores, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoStoresFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/stores/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Store> store = storeRepo.findById(id);
		
		if (!store.isPresent()) {
			return new ResponseEntity<>("StoreNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
	
	@PostMapping("/store")
	public ResponseEntity<Object> addStore(@RequestBody Store store){
		
		UUID customId = UUID.fromString("00000000-0000-0000-0000-00000000" + store.getSimpleStoreId());
		store.setId(customId);
		
		store.setCreatedAt(LocalDateTime.now());
		store.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(storeRepo.save(store), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
