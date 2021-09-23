package com.payment.upi.dao;

import java.util.List;

import com.payment.upi.wallet.Wallet;

public interface WalletDao {
	Wallet save_account(Wallet customer);
	void delete_account(long mobile);
	Wallet findByMobile(long mobile);
	List<Wallet> findAll();
}
