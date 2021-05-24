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

import disproject.svarog.models.Site;
import disproject.svarog.repositories.SiteRepository;

@RestController
public class SiteController {

	@Autowired
	private SiteRepository siteRepo;
	
	@GetMapping("/sites")
	public ResponseEntity<Object> getAllSites() {
		List<Site> sites = siteRepo.findAll();
		
		if (!sites.isEmpty()) {
			return new ResponseEntity<>(sites, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoSitesFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/sites/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Site> site = siteRepo.findById(id);
		
		if (!site.isPresent()) {
			return new ResponseEntity<>("SiteNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(site, HttpStatus.OK);
	}
}
