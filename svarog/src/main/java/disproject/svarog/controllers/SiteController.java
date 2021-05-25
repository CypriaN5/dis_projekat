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
	
	
	@PostMapping("/site") 
	public ResponseEntity<Object> addSite(@RequestBody Site site){
		
		UUID customId = UUID.fromString("00000000-0000-0000-0000-00000000" + site.getSimpleSiteId());
		site.setId(customId);
		
		site.setCreatedAt(LocalDateTime.now());
		site.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(siteRepo.save(site), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
