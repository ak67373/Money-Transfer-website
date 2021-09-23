package com.payment.upi.service;

import java.util.List;

import com.payment.upi.Banks.AXIS;


public interface AXISBankService {

	public int createNewProduct(AXIS toBeCreated);
	public void removeExisting(int id);
	public List<AXIS> findAll();
	public AXIS findById(int id);
}
