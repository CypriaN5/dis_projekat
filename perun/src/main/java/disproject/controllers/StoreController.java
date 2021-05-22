package disproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.Store;
import disproject.perun.repositories.StoreRepository;

@RestController
public class StoreController {

	@Autowired
	private StoreRepository storeRepo;
	
	@GetMapping("/stores")
	public List<Store> getAllStores(){
		
		return storeRepo.findAll();
		
	}
	
}
