package com.payment.upi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.payment.upi.transaction.BankTransaction;

@RestController
public class BankTransactionController {

	@Autowired
	BankTransaction process;

	@PatchMapping("/moneytransferfrom/{bankcode1}/{id1}/to/{bankcode2}/{id2}/{amount}")
	public ResponseEntity<String> addMoneyTOBank(@PathVariable("bankcode1") String bankcode1,
			@PathVariable("id1") int id1, @PathVariable("bankcode2") String bankcode2, @PathVariable("id2") int id2,
			@PathVariable("amount") double amount) {
		try {
			boolean flag = process.transferMoney(bankcode1, id1, amount, bankcode2, id2);
			if (flag == true) {
				return new ResponseEntity<String>("Ammount is trasfered successfully", HttpStatus.OK);
			} else
				return new ResponseEntity<String>("Please enter an amount less than equal to your balance.",
						HttpStatus.NOT_FOUND);

		} catch (IllegalArgumentException e) {
			return new ResponseEntity<String>("Transaction is failed", HttpStatus.BAD_REQUEST);
		}

	}
}
