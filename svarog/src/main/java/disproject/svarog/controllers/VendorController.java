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

import disproject.svarog.models.Vendor;
import disproject.svarog.repositories.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping("/vendors")
	public ResponseEntity<Object> getAllVendors() {
		List<Vendor> vendors = vendorRepo.findAll();
		
		if (!vendors.isEmpty()) {
			return new ResponseEntity<>(vendors, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoVendorsFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/vendors/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Vendor> vendor = vendorRepo.findById(id);
		
		if (!vendor.isPresent()) {
			return new ResponseEntity<>("VendorNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(vendor, HttpStatus.OK);
	}
}
