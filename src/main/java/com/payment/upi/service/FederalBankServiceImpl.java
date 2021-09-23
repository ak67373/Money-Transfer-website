package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.FEDERAL;
import com.payment.upi.dao.FederalDao;

@Service
@Transactional
public class FederalBankServiceImpl implements FederalBankService {

	FederalDao dao;

	@Autowired
	public void setDao(FederalDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(FEDERAL toBeCreated) {
		FEDERAL created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		FEDERAL existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);
	}

	@Override
	public List<FEDERAL> findAll() {
		return dao.findAll();
	}

	@Override
	public FEDERAL findById(int id) {
		return dao.findById(id);
	}
	

}
