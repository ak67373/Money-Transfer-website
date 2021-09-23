package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.HDFC;
import com.payment.upi.dao.HDFCDao;

@Service
@Transactional
public class HDFCBankServiceImpl implements HDFCBankService{

	@Autowired
	HDFCDao dao;
	
	@Autowired
	public void setDao(HDFCDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(HDFC toBeCreated) {
		HDFC created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		HDFC existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);
	}

	@Override
	public List<HDFC> findAll() {
		return dao.findAll();
	}

	@Override
	public HDFC findById(int id) {
		return dao.findById(id);
	}
}
