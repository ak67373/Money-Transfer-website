package com.payment.upi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.upi.Banks.FEDERAL;
import com.payment.upi.dao.FederalDaoJpaImpl;
import com.payment.upi.service.FederalBankServiceImpl;

@Service
public class FederalTransaction {

	@Autowired
	FederalBankServiceImpl service;

	@Autowired
	FederalDaoJpaImpl dao;
	

	public void addMoneyToBank(int id, double amount) {

		FEDERAL account = service.findById(id);
		account.setBalance(amount + account.getBalance());
		dao.save_account(account);

	}

	public boolean withdrawMoneyFromBank(int id, double amount) {
		FEDERAL account = service.findById(id);
		if (amount <= account.getBalance()) {
			account.setBalance(account.getBalance() - amount);
			dao.save_account(account);
			return true;
		} else
			return false;

	}
}
