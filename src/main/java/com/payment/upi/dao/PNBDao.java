package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.PNB;

public interface PNBDao {

	PNB save_account(PNB customer);
	void delete_account(int cust_id);
	PNB findById(int cust_id);
	List<PNB > findAll();
}
