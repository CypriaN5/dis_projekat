package disproject.svarog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.svarog.models.Vendor;
import disproject.svarog.repositories.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepo;
	
	@GetMapping("/vendors")
	public List<Vendor> getAllVendors(){
		
		return vendorRepo.findAll();
		
	}
	
}
