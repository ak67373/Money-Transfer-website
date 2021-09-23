package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.ICICI;

@Primary
@Repository
@Transactional
public class ICICIDaoJpaImpl implements ICICIDao{

	@Autowired
	EntityManager em;

	@Override
	public ICICI save_account(ICICI customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		ICICI p = em.find(ICICI.class, cust_id);
		em.remove(p);
	}

	@Override
	public ICICI findById(int cust_id) {
		ICICI p = em.find(ICICI.class, cust_id);
		return p;
	}

	@Override
	public List<ICICI> findAll() {
		Query q = em.createQuery("select p from ICICI as p");
		return q.getResultList();
	}
}
