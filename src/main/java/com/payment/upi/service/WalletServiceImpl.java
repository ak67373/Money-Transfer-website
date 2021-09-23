package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.dao.WalletDao;
import com.payment.upi.wallet.Wallet;

@Service
@Transactional
public class WalletServiceImpl implements WalletService{

	WalletDao dao;
	
	@Autowired
	public void setDao(WalletDao dao) {
		this.dao = dao;
	}
	
	@Override
	public long createNewProduct(Wallet toBeCreated) {
		Wallet created = dao.save_account(toBeCreated);
		return created.getMobile();
	}

	@Override
	public void removeExisting(long mobile) {
		Wallet existing = dao.findByMobile(mobile);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + mobile + " not found!");
		}
		dao.delete_account(mobile);		
	}

	@Override
	public List<Wallet> findAll() {
		return dao.findAll();
	}

	@Override
	public Wallet findByMobile(long mobile) {
		return dao.findByMobile(mobile);
	}
}
