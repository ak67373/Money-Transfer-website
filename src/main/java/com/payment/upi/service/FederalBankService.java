package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.FEDERAL;

public interface FederalBankService {
	
	public int createNewProduct(FEDERAL toBeCreated);
	public void removeExisting(int id);
	public List<FEDERAL> findAll();
	public FEDERAL findById(int id);
}
