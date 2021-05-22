package disproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.AppUser;
import disproject.perun.repositories.AppUserRepository;

@RestController
public class AppUserController {
	
	@Autowired
	private AppUserRepository appUserRepo;
	
	@GetMapping("/app-users")
	public List<AppUser> getAllUsers(){
		
		return appUserRepo.findAll();
		
	}

}
