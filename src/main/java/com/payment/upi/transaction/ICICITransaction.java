package com.payment.upi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.upi.Banks.ICICI;
import com.payment.upi.dao.ICICIDaoJpaImpl;
import com.payment.upi.service.ICICIBankServiceImpl;

@Service
public class ICICITransaction {

	@Autowired
	ICICIBankServiceImpl service;

	@Autowired
	ICICIDaoJpaImpl dao;

	public void addMoneyToBank(int id, double amount) {

		ICICI account = service.findById(id);
		account.setBalance(amount + account.getBalance());
		dao.save_account(account);

	}

	public boolean withdrawMoneyFromBank(int id, double amount) {
		ICICI account = service.findById(id);
		if (amount <= account.getBalance()) {
			account.setBalance(account.getBalance() - amount);
			dao.save_account(account);
			return true;
		} else
			return false;

	}

}
