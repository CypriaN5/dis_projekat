package disproject.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import disproject.perun.models.AppUser;
import disproject.perun.repositories.AppUserRepository;

@RestController
public class AppUserController {
	
	@Autowired
	private AppUserRepository appUserRepo;

	
	@GetMapping("/app-users")
	public ResponseEntity<Object> getAllAppUsers() {
		List<AppUser> appUsers = appUserRepo.findAll();
		
		if (!appUsers.isEmpty()) {
			return new ResponseEntity<>(appUsers, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoAppUsersFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/app-users/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<AppUser> appUser = appUserRepo.findById(id);
		
		if (!appUser.isPresent()) {
			return new ResponseEntity<>("AppUserNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(appUser, HttpStatus.OK);
	}

}
