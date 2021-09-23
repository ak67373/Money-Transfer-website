package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.PNB;

@Primary
@Repository
@Transactional
public class PNBDaoJpaImpl implements PNBDao{

	@Autowired
	EntityManager em;

	@Override
	public PNB save_account(PNB customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		PNB p = em.find(PNB.class, cust_id);
		em.remove(p);
	}

	@Override
	public PNB findById(int cust_id) {
		PNB p = em.find(PNB.class, cust_id);
		return p;
	}

	@Override
	public List<PNB> findAll() {
		Query q = em.createQuery("select p from PNB as p");
		return q.getResultList();
	}
}
