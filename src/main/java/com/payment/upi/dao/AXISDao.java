package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.AXIS;


public interface AXISDao {
	AXIS save_account(AXIS customer);
	void delete_account(int cust_id);
	AXIS findById(int cust_id);
	List<AXIS> findAll();
}
