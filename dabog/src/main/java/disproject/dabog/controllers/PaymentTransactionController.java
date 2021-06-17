package disproject.dabog.controllers;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.Card;
import disproject.dabog.models.PaymentTransaction;
import disproject.dabog.models.User;
import disproject.dabog.proxies.PerunProxy;
import disproject.dabog.repositories.CardRepository;
import disproject.dabog.repositories.PaymentTransactionRepository;
import disproject.dabog.repositories.UserRepository;

@RestController
public class PaymentTransactionController {
	
	@Autowired
	private PaymentTransactionRepository paymentTransactionRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private CardRepository cardRepo;
	
	@Autowired
	private PerunProxy perunProxy;
	
	@GetMapping("/payment-transactions")
	public ResponseEntity<Object> getAllPaymentTransactions() {
		
		return new ResponseEntity<>(paymentTransactionRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/payment-transactions/{id}")
	public ResponseEntity<Object> getOne(@PathVariable UUID id) {
		
		Optional<PaymentTransaction> paymentTransaction = paymentTransactionRepo.findById(id);
		
		if (!paymentTransaction.isPresent()) {
			return new ResponseEntity<>("PaymentTransactionNotFound", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(paymentTransaction, HttpStatus.OK);
	}
	
	@PostMapping("/payment-transaction") 
	public ResponseEntity<Object> addPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction, 
			@RequestParam UUID userId, @RequestParam UUID cardId){
		
		Optional<User> optionalUser = userRepo.findById(userId);	
		if (!optionalUser.isPresent()) {
			return new ResponseEntity<>("UserNotFound", HttpStatus.NOT_FOUND);
		}
		paymentTransaction.setUser(optionalUser.get());
		
		Optional<Card> optionalCard = cardRepo.findById(cardId);
		if (!optionalCard.isPresent()) {
			return new ResponseEntity<>("CardNotFound", HttpStatus.NOT_FOUND);
		}
		paymentTransaction.setCard(optionalCard.get());
		
		try {
			perunProxy.closePerunBasket(paymentTransaction.getPaymentRefId());
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		paymentTransaction.setCreatedAt(LocalDateTime.now());
		paymentTransaction.setUpdatedAt(LocalDateTime.now());
		
		try {
			//return new ResponseEntity<>("Success", HttpStatus.OK);
			return new ResponseEntity<>(paymentTransactionRepo.save(paymentTransaction), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

}
