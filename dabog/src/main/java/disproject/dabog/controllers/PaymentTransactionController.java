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
import org.springframework.web.bind.annotation.RestController;

import disproject.dabog.models.PaymentTransaction;
import disproject.dabog.repositories.PaymentTransactionRepository;

@RestController
public class PaymentTransactionController {
	
	@Autowired
	private PaymentTransactionRepository paymentTransactionRepo;
	
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
	public ResponseEntity<Object> addPaymentTransaction(@RequestBody PaymentTransaction paymentTransaction){
		
		
		paymentTransaction.setCreatedAt(LocalDateTime.now());
		paymentTransaction.setUpdatedAt(LocalDateTime.now());
		
		try {
			return new ResponseEntity<>(paymentTransactionRepo.save(paymentTransaction), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	

}
