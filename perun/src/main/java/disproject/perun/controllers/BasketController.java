package disproject.perun.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import disproject.perun.models.ErrorItem;
import disproject.perun.proxies.SvarogProxy;
import disproject.perun.repositories.BasketRepository;


@RestController
public class BasketController {

	@Autowired
	private BasketRepository basketRepo;
	
	@Autowired
	private SvarogProxy svarogProxy;
	
	
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
	public ResponseEntity<Object> addBasket(@RequestBody Basket tempBasket) {

		Basket basket = new Basket();
		if (tempBasket.getId() != null) {
			basket = basketRepo.findById(tempBasket.getId()).get();
			basket.setStoreId(tempBasket.getStoreId());
			basket.setItems(tempBasket.getItems());
			basket.setUpdatedAt(LocalDateTime.now());
		} else {
			basket = tempBasket;
			basket.setItems(tempBasket.getItems());
			basket.setCreatedAt(LocalDateTime.now());
			basket.setUpdatedAt(LocalDateTime.now());
		}
		
		if (basket.isClosed() == true) {
			return new ResponseEntity<>("BasketIsClosed", HttpStatus.BAD_REQUEST);
		}
		
		// Fetch items from Svarog and then populate/calculate  basket
		List<Item> itemsFromSvarog = svarogProxy.retrieveItems(basket.getItems());
		
		List<ErrorItem> errorItems = new ArrayList<ErrorItem>();
		
		List<String> knownEans = new ArrayList<String>();
		
		for (Item item : itemsFromSvarog) {
			knownEans.add(item.getEan13());
		}
		
		for (Item itemToCheck : basket.getItems()) {
			if (!knownEans.contains(itemToCheck.getEan13())) {
				ErrorItem errorItem = new ErrorItem(itemToCheck.getEan13(), "Unknown item");
				errorItems.add(errorItem);
			}
		}
		
		basket.setItems(itemsFromSvarog);
		
		basket.setErrors(errorItems);
		
		List<Item> items = basket.getItems();
		
		basket.setTotalPrice(0);
		for (Item item : items) {
			basket.setTotalPrice(basket.getTotalPrice() + item.getTotalPrice());
		}
		
		if (basket.getPaymentRefId() == null) {
			int nextPaymentRef = basketRepo.getNextPaymentRef();
			basket.setPaymentRefId("PR"+nextPaymentRef);
		}
		
		try {
			return new ResponseEntity<>(basketRepo.save(basket), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/basket/{id}")
	public ResponseEntity<Object> updateBasket(@PathVariable UUID id, @RequestBody Basket basketTemp) {
		
		//not fully developed
		
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


	//API call to close basket from dabog
	@PutMapping("/basket/{id}/close")
	public ResponseEntity<Object> closeBasket(@PathVariable UUID id) {
		
		Optional<Basket> basketOptional = basketRepo.findById(id);
		
		if (!basketOptional.isPresent()) {
			return new ResponseEntity<>("BasketNotFound", HttpStatus.NOT_FOUND);
		}
		
		Basket basket = basketOptional.get();
		
		if (basket.isClosed() == true) {
			return new ResponseEntity<>("BasketAlreadyClosed", HttpStatus.BAD_REQUEST);
		}
		
		basket.setClosed(true);
		
		try {
			basketRepo.save(basket);
			return new ResponseEntity<>("success", HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
