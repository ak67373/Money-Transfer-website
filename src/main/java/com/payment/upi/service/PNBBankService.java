package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.PNB;

public interface PNBBankService {

	public int createNewProduct(PNB toBeCreated);
	public void removeExisting(int id);
	public List<PNB> findAll();
	public PNB findById(int id);
}
