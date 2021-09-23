package com.payment.upi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.payment.upi.wallet.Wallet;

@Primary
@Repository
@Transactional
public class WalletDaoJpaImpl implements WalletDao{

	@Autowired
	EntityManager em;

	@Override
	public Wallet save_account(Wallet customer) {
		em.persist(customer);
		return customer;
	}

	@Override
	public void delete_account(long mobile) {
		Wallet p = em.find(Wallet.class, mobile);
		em.remove(p);
	}

	@Override
	public Wallet findByMobile(long mobile) {
		Wallet p = em.find(Wallet.class, mobile);
		return p;
	}

	@Override
	public List<Wallet> findAll() {
		Query q = em.createQuery("select p from Wallet as p");
		return q.getResultList();
	}
}
