package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.HDFC;

public interface HDFCDao {

	HDFC save_account(HDFC  customer);
	void delete_account(int cust_id);
	HDFC findById(int cust_id);
	List<HDFC > findAll();
}
