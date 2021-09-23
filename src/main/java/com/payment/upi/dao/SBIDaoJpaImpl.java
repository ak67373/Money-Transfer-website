package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.SBI;

@Primary
@Repository
@Transactional
public class SBIDaoJpaImpl implements SBIDao{

	@Autowired
	EntityManager em;

	@Override
	public SBI save_account(SBI customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		SBI p = em.find(SBI.class, cust_id);
		em.remove(p);
	}

	@Override
	public SBI findById(int cust_id) {
		SBI p = em.find(SBI.class, cust_id);
		return p;
	}

	@Override
	public List<SBI> findAll() {
		Query q = em.createQuery("select p from SBI as p");
		return q.getResultList();
	}
}
