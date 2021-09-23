package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.ICICI;

public interface ICICIBankService {

	public int createNewProduct(ICICI toBeCreated);
	public void removeExisting(int id);
	public List<ICICI> findAll();
	public ICICI findById(int id);
}
