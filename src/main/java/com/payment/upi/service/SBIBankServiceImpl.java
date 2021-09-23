package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.SBI;
import com.payment.upi.dao.SBIDao;

@Service
@Transactional
public class SBIBankServiceImpl implements SBIBankService{
	
	@Autowired
	SBIDao dao;
	
	@Autowired
	public void setDao(SBIDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(SBI toBeCreated) {
		SBI created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		SBI existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);
	}

	@Override
	public List<SBI> findAll() {
		return dao.findAll();
	}

	@Override
	public SBI findById(int id) {
		return dao.findById(id);
	}

}
