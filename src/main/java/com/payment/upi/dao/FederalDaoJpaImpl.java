package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.FEDERAL;

@Primary
@Repository
@Transactional
public class FederalDaoJpaImpl implements FederalDao{
	@Autowired
	EntityManager em;

	@Override
	public FEDERAL save_account(FEDERAL customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		FEDERAL p = em.find(FEDERAL.class, cust_id);
		em.remove(p);
	}

	@Override
	public FEDERAL findById(int cust_id) {
		FEDERAL p = em.find(FEDERAL.class, cust_id);
		return p;
	}

	@Override
	public List<FEDERAL> findAll() {
		Query q = em.createQuery("select p from FEDERAL as p");
		return q.getResultList();
	}

}
