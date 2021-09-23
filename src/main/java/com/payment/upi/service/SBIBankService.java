package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.SBI;

public interface SBIBankService {

	public int createNewProduct(SBI toBeCreated);
	public void removeExisting(int id);
	public List<SBI> findAll();
	public SBI findById(int id);
}
