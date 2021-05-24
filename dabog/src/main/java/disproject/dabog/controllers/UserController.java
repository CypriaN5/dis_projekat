package disproject.dabog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.User;
import disproject.dabog.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
