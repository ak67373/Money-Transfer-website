package com.payment.upi.service;

import java.util.List;

import com.payment.upi.wallet.Wallet;

public interface WalletService {
	public long createNewProduct(Wallet toBeCreated);
	public void removeExisting(long mobile);
	public List<Wallet> findAll();
	public Wallet findByMobile(long mobile);
}
