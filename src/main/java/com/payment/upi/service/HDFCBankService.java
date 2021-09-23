package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.HDFC;

public interface HDFCBankService {

	public int createNewProduct(HDFC toBeCreated);
	public void removeExisting(int id);
	public List<HDFC> findAll();
	public HDFC findById(int id);
}
