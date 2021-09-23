package com.payment.upi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.upi.service.WalletService;
import com.payment.upi.transaction.WalletTransaction;
import com.payment.upi.wallet.Wallet;

@RestController
public class WalletController {

	@Autowired
	WalletService service;

	@Autowired
	WalletTransaction process;

	@GetMapping("/wallet_accounts")
	public List<Wallet> getAllAccounts() {
		return service.findAll();
	}

	@GetMapping("/wallet_account/{mobile}")
	public Wallet getAccountById(@PathVariable("mobile") long mobile) {
		Wallet user = service.findByMobile(mobile);
		return user;
	}

	@PostMapping("/wallet_account")
	public ResponseEntity<String> addNewProduct(@RequestBody Wallet toBeAdded) {
		try {
			long mobile = service.createNewProduct(toBeAdded);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/wallet_account/" + mobile));
			return new ResponseEntity<String>("Account is created Successfully", HttpStatus.OK);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/wallet_account/addMoneyToWallet/{mobile}/{amount}")
	public ResponseEntity<String> addMoneyToWallet(@PathVariable("mobile") long mobile,
			@PathVariable("amount") double amount) {
		try {
			boolean flag = process.addMoneyfromBank(mobile, amount);
			if (flag == true)
				return new ResponseEntity<String>("Transaction is successfully completed", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Please enter an amount less than equal to your balance.",
						HttpStatus.NOT_FOUND);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/wallet_account/addMoneyToBank/{mobile}/{amount}")
	public ResponseEntity<String> addMoneyTOBank(@PathVariable("mobile") long mobile,
			@PathVariable("amount") double amount) {
		try {
			boolean flag = process.addMoneyToBank(mobile, amount);
			if (flag == true)
				return new ResponseEntity<String>("Transaction is successfully completed", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Please enter an amount less than equal to your balance.",
						HttpStatus.NOT_FOUND);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}
	}

	@PatchMapping("/wallet_account/transferMoney/{mobile1}/{mobile2}/{amount}")
	public ResponseEntity<String> transferMoney(@PathVariable("mobile1") long mobile1, @PathVariable("mobile2") long mobile2,
			@PathVariable("amount") double amount) {
		try {
			boolean flag = process.transferMoney(mobile1, mobile2, amount);
			if (flag == true)
				return new ResponseEntity<String>("Transaction is successfully completed", HttpStatus.OK);
			else
				return new ResponseEntity<String>("Please enter an amount less than equal to your balance.",
						HttpStatus.NOT_FOUND);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}
	}

}
