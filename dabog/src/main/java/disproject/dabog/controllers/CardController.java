package disproject.dabog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
