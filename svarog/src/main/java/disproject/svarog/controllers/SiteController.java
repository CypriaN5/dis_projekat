package disproject.svarog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.svarog.models.Site;
import disproject.svarog.repositories.SiteRepository;

@RestController
public class SiteController {

	@Autowired
	private SiteRepository siteRepo;
	
	@GetMapping("/sites")
	public List<Site> getAllSites(){
		
		return siteRepo.findAll();
		
	}
}
