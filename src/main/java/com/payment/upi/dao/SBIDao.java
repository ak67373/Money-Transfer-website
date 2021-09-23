package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.Banks.SBI;

public interface SBIDao {

	SBI save_account(SBI customer);
	void delete_account(int cust_id);
	SBI findById(int cust_id);
	List<SBI> findAll();
}
