package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.ICICI;

public interface ICICIDao {
	ICICI save_account(ICICI  customer);
	void delete_account(int cust_id);
	ICICI findById(int cust_id);
	List<ICICI > findAll();
}
