package disproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.Basket;
import disproject.perun.repositories.BasketRepository;

@RestController
public class BasketController {

	@Autowired
	private BasketRepository basketRepo;
	
	
	@GetMapping("/baskets")
	public List<Basket> getAllBaskets(){
		
		return basketRepo.findAll();
		
	}
	
}
