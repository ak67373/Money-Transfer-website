package com.payment.upi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.upi.Banks.HDFC;
import com.payment.upi.service.HDFCBankService;
import com.payment.upi.transaction.HDFCTransaction;

@RestController
public class HDFCController {

	@Autowired
	HDFCBankService service;

	@Autowired
	HDFCTransaction process;

	@GetMapping("/hdfc_accounts")
	public List<HDFC> getAllAccounts() {
		return service.findAll();
	}

	@GetMapping("/hdfc_account/{id}")
	public HDFC getAccountById(@PathVariable("id") int id) {
		return service.findById(id);
	}

	@PostMapping("/hdfc_account")
	public ResponseEntity<String> addNewProduct(@RequestBody HDFC toBeAdded) {
		try {
			if (toBeAdded.getBalance() < 1000.0) {
				return new ResponseEntity<String>(
						"Transaction is failed, Please add initial amount greater equal 1000.0",
						HttpStatus.BAD_REQUEST);
			} else {
				int id = service.createNewProduct(toBeAdded);
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(URI.create("/axis_account/" + id));
				return new ResponseEntity<String>("Account is created Successfully", HttpStatus.OK);
			}
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/hdfc_account/add/{id}/{amount}")
	public ResponseEntity<String> addMoneyTOBank(@PathVariable("id") int id, @PathVariable("amount") double amount) {
		try {
			process.addMoneyToBank(id, amount);
			return new ResponseEntity<String>("Ammount is added successfully", HttpStatus.OK);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}

	}

	@PatchMapping("/hdfc_account/withdraw/{id}/{amount}")
	public ResponseEntity<String> WithdrawMoneyFROMBank(@PathVariable("id") int id,
			@PathVariable("amount") double amount) {
		try {
			boolean f = process.withdrawMoneyFromBank(id, amount);
			if (f == true)
				return new ResponseEntity<String>("Transaction is successfully completed", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Please enter an amount less than equal to your balance.",
						HttpStatus.NOT_FOUND);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/hdfc_account/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
		try {
			service.removeExisting(id);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		} catch (IllegalStateException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

}
