package com.payment.upi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.upi.Banks.AXIS;
import com.payment.upi.dao.AXISDaoJpaImpl;
import com.payment.upi.service.AXISBankServiceImpl;

@Service
public class AXISTransaction {

	@Autowired
	AXISBankServiceImpl service;
	
	@Autowired 
	AXISDaoJpaImpl dao;
	
	
	public void addMoneyToBank(int id, double amount) {
		
		AXIS account = service.findById(id);
		account.setBalance(amount+account.getBalance());
		dao.save_account(account);
		
	}
	
	public boolean withdrawMoneyFromBank(int id, double amount) {
		AXIS account = service.findById(id);
		if(amount<=account.getBalance()) {
			account.setBalance(account.getBalance()-amount);
			dao.save_account(account);
			return true;
		}
		else return false;

	}
	
}
