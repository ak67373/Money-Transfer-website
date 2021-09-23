package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.AXIS;
import com.payment.upi.dao.AXISDao;

@Service
@Transactional
public class AXISBankServiceImpl implements AXISBankService{
	
	AXISDao dao;
	
	@Autowired
	public void setDao(AXISDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(AXIS toBeCreated) {
		AXIS created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		AXIS existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);		
	}

	@Override
	public List<AXIS> findAll() {
		return dao.findAll();
	}

	@Override
	public AXIS findById(int id) {
		return dao.findById(id);
	}

}
