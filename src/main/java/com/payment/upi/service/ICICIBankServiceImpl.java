package com.payment.upi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.ICICI;
import com.payment.upi.dao.ICICIDao;

@Service
@Transactional
public class ICICIBankServiceImpl implements ICICIBankService{
	
	@Autowired
	ICICIDao dao;
	
	@Autowired
	public void setDao(ICICIDao dao) {
		this.dao = dao;
	}

	@Override
	public int createNewProduct(ICICI toBeCreated) {
		ICICI created = dao.save_account(toBeCreated);
		return created.getId();
	}

	@Override
	public void removeExisting(int id) {
		ICICI existing = dao.findById(id);

		if (existing == null) {
			throw new IllegalArgumentException("product with id " + id + " not found!");
		}
		dao.delete_account(id);
	}

	@Override
	public List<ICICI> findAll() {
		return dao.findAll();
	}

	@Override
	public ICICI findById(int id) {
		return dao.findById(id);
	}

}
