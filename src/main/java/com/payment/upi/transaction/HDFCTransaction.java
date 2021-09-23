package com.payment.upi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.upi.Banks.HDFC;
import com.payment.upi.dao.HDFCDaoJpaImpl;
import com.payment.upi.service.HDFCBankServiceImpl;

@Service
public class HDFCTransaction {

	@Autowired
	HDFCBankServiceImpl service;

	@Autowired
	HDFCDaoJpaImpl dao;

	public void addMoneyToBank(int id, double amount) {

		HDFC account = service.findById(id);
		account.setBalance(amount + account.getBalance());
		dao.save_account(account);

	}

	public boolean withdrawMoneyFromBank(int id, double amount) {
		HDFC account = service.findById(id);
		if (amount <= account.getBalance()) {
			account.setBalance(account.getBalance() - amount);
			dao.save_account(account);
			return true;
		} else
			return false;

	}
}
