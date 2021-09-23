package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.Banks.AXIS;

@Primary
@Repository
@Transactional
public class AXISDaoJpaImpl implements AXISDao {

	@Autowired
	EntityManager em;

	@Override
	public AXIS save_account(AXIS customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(int cust_id) {
		AXIS p = em.find(AXIS.class, cust_id);
		em.remove(p);
	}

	@Override
	public AXIS findById(int cust_id) {
		AXIS p = em.find(AXIS.class, cust_id);
		return p;
	}

	@Override
	public List<AXIS> findAll() {
		Query q = em.createQuery("select p from AXIS as p");
		return q.getResultList();
	}


}
