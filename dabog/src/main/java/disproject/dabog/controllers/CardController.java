package disproject.dabog.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.Card;
import disproject.dabog.repositories.CardRepository;

@RestController
public class CardController {

	@Autowired
	private CardRepository cardRepo;
	
	@GetMapping("/cards")
	public List<Card> getAllUsers() {
		return cardRepo.findAll();
	}
	
	@GetMapping("/cards/{id}")
	public Optional<Card> getOne(@PathVariable UUID id) {
		return cardRepo.findById(id);
	}
}
