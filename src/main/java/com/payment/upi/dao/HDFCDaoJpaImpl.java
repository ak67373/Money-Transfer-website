package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.HDFC;

@Primary
@Repository
@Transactional
public class HDFCDaoJpaImpl implements HDFCDao {

	@Autowired
	EntityManager em;

	@Override
	public HDFC save_account(HDFC customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		HDFC p = em.find(HDFC.class, cust_id);
		em.remove(p);
	}

	@Override
	public HDFC findById(int cust_id) {
		HDFC p = em.find(HDFC.class, cust_id);
		return p;
	}

	@Override
	public List<HDFC> findAll() {
		Query q = em.createQuery("select p from HDFC as p");
		return q.getResultList();
	}
}
