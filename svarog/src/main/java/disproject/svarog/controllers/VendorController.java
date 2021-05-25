package disproject.svarog.controllers;

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

import disproject.svarog.models.Item;
import disproject.svarog.models.Vendor;
import disproject.svarog.repositories.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepo;
	
	
	@GetMapping("/vendors")
	public ResponseEntity<Object> getAllVendors() {
		List<Vendor> vendors = vendorRepo.findAll();
		
		if (vendors.isEmpty()) {
			return new ResponseEntity<>("NoVendorsFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(vendors, HttpStatus.OK);
	}
	
	@GetMapping("/vendors/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Vendor> vendor = vendorRepo.findById(id);
		
		if (!vendor.isPresent()) {
			return new ResponseEntity<>("VendorNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}
	
	//Get items for a vendor
	@GetMapping("/vendors/{id}/items")
	public ResponseEntity<Object> getItemsForVendor(@PathVariable UUID id){
		Optional<Vendor> vendor = vendorRepo.findById(id);
		
		if (!vendor.isPresent()) {
			return new ResponseEntity<>("VendorNotFound", HttpStatus.NOT_FOUND);
		}
		
		List<Item> vendorItems = vendor.get().getItems();
		
		if (vendorItems.isEmpty()) {
			return new ResponseEntity<>("NoItemsFoundForVendor", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(vendorItems, HttpStatus.OK);
	}
	
	@PostMapping("/vendor") 
	public ResponseEntity<Object> addVendor(@RequestBody Vendor vendor){
		
		UUID customId = UUID.fromString("00000000-0000-0000-0000-00000000" + vendor.getSimpleVendorId());
		vendor.setId(customId);
		
		vendor.setCreatedAt(LocalDateTime.now());
		vendor.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(vendorRepo.save(vendor), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
