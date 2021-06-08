package disproject.dabog.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.Card;
import disproject.dabog.repositories.CardRepository;


@RestController
public class CardController {

	@Autowired
	private CardRepository cardRepo;
	
	@GetMapping("/cards")
	public ResponseEntity<Object> getAllCards() {
		
		List<Card> cards = cardRepo.findByIsDeleted(false);
		
		if (!cards.isEmpty()) {
			return new ResponseEntity<>(cards, HttpStatus.OK);
		}
		
		return new ResponseEntity<>("NoCardsFound", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/cards/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<Card> card = cardRepo.findById(id);
		
		if (!card.isPresent() || card.get().isDeleted() == true) {
			return new ResponseEntity<>("CardNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(card, HttpStatus.OK);
	}
	
	@PostMapping("/card") 
	public ResponseEntity<Object> addCard(@RequestBody Card card){
		
		
		card.setDeleted(false);
		card.setCreatedAt(LocalDateTime.now());
		card.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(cardRepo.save(card), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("card/{id}")
	public ResponseEntity<Object> deleteCard(@PathVariable UUID id){
		
		Optional<Card> card = cardRepo.findById(id);
		
		if (!card.isPresent()) {
			return new ResponseEntity<>("CardNotFound", HttpStatus.NOT_FOUND);
		}
		
		card.get().setDeleted(true);
		card.get().setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(cardRepo.save(card.get()), HttpStatus.OK) ;
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
