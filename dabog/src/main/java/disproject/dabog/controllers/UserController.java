package disproject.dabog.controllers;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.Card;
import disproject.dabog.models.User;
import disproject.dabog.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAllUsers() {
		List<User> users = userRepo.findAll();
		
		if (!users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoUsersFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<User> user = userRepo.findById(id);
		
		if (!user.isPresent()) {
			return new ResponseEntity<>("UserNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//Get cards for user
	@GetMapping("/users/{id}/cards")
	public ResponseEntity<Object> getCardsforUser(@PathVariable UUID id) {
		
		Optional<User> user = userRepo.findById(id);
		
		if (!user.isPresent()) {
			return new ResponseEntity<>("UserNotFound", HttpStatus.NOT_FOUND);
		}
		
		List<Card> cards = user.get().getCards();
		
		cards.removeIf(card -> card.isDeleted() == true);
		
		if (cards.isEmpty()) {
			return new ResponseEntity<>("NoCardsFoundForUser", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(cards, HttpStatus.OK);
	}
	
	@PostMapping("/user") 
	public ResponseEntity<Object> addUser(@RequestBody User user){
		
		
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable UUID id, @RequestBody User userTemp){
		
		Optional<User> userOptional = userRepo.findById(id);
		
		if (!userOptional.isPresent()) {
			return new ResponseEntity<>("UserNotFound", HttpStatus.NOT_FOUND);
		}
		
		User user = userOptional.get();
		
		user.setEmail(userTemp.getEmail());
		user.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
