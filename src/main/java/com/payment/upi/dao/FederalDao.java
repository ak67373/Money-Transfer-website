package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.FEDERAL;


public interface FederalDao {
	FEDERAL save_account(FEDERAL customer);
	void delete_account(int cust_id);
	FEDERAL findById(int cust_id);
	List<FEDERAL> findAll();
}
