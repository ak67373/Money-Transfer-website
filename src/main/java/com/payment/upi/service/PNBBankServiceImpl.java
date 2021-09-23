package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.PNB;
import com.payment.upi.dao.PNBDao;

@Service
@Transactional
public class PNBBankServiceImpl implements PNBBankService{
	
	@Autowired 
	PNBDao dao;
	
	@Autowired
	public void setDao(PNBDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(PNB toBeCreated) {
		PNB created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		PNB existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);
	}

	@Override
	public List<PNB> findAll() {
		return dao.findAll();
	}

	@Override
	public PNB findById(int id) {
		return dao.findById(id);
	}

}
