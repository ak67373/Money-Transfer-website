package com.payment.upi.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.upi.Banks.AXIS;
import com.payment.upi.Banks.FEDERAL;
import com.payment.upi.Banks.HDFC;
import com.payment.upi.Banks.ICICI;
import com.payment.upi.Banks.PNB;
import com.payment.upi.Banks.SBI;
import com.payment.upi.dao.AXISDaoJpaImpl;
import com.payment.upi.dao.FederalDaoJpaImpl;
import com.payment.upi.dao.HDFCDaoJpaImpl;
import com.payment.upi.dao.ICICIDaoJpaImpl;
import com.payment.upi.dao.PNBDaoJpaImpl;
import com.payment.upi.dao.SBIDaoJpaImpl;
import com.payment.upi.dao.WalletDao;
import com.payment.upi.service.AXISBankServiceImpl;
import com.payment.upi.service.FederalBankServiceImpl;
import com.payment.upi.service.HDFCBankServiceImpl;
import com.payment.upi.service.ICICIBankServiceImpl;
import com.payment.upi.service.PNBBankServiceImpl;
import com.payment.upi.service.SBIBankServiceImpl;
import com.payment.upi.service.WalletServiceImpl;
import com.payment.upi.wallet.Wallet;

@Service
public class WalletTransaction {

	@Autowired
	WalletServiceImpl service;

	@Autowired
	WalletDao dao;

	@Autowired
	AXISBankServiceImpl axisService;

	@Autowired
	AXISDaoJpaImpl axisDao;

	@Autowired
	FederalBankServiceImpl federalService;

	@Autowired
	FederalDaoJpaImpl federalDao;

	@Autowired
	HDFCBankServiceImpl hdfcService;

	@Autowired
	HDFCDaoJpaImpl hdfcDao;

	@Autowired
	ICICIBankServiceImpl iciciService;

	@Autowired
	ICICIDaoJpaImpl iciciDao;

	@Autowired
	PNBBankServiceImpl pnbService;

	@Autowired
	PNBDaoJpaImpl pnbDao;

	@Autowired
	SBIBankServiceImpl sbiService;

	@Autowired
	SBIDaoJpaImpl sbiDao;

	public boolean addMoneyfromBank(long mobile, double amount) {

		Wallet user = service.findByMobile(mobile);
		String bankCode = user.getBankcode();
		int id = user.getBankId();

		boolean flag = true;

		switch (bankCode) {

		case "axis0011": {
			AXIS account = axisService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				axisDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "federal0012": {
			FEDERAL account = federalService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				federalDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "hdfc0013": {
			HDFC account = hdfcService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				hdfcDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "icici0014": {
			ICICI account = iciciService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				iciciDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "pnb0015": {
			PNB account = pnbService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				pnbDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "sbi0016": {
			SBI account = sbiService.findById(id);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				sbiDao.save_account(account);
				user.setBalance(amount + user.getBalance());
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}

		}

		return flag;

	}

	public boolean addMoneyToBank(long mobile, double amount) {
		Wallet user = service.findByMobile(mobile);
		String bankCode = user.getBankcode();
		int id = user.getBankId();

		boolean flag = true;

		switch (bankCode) {

		case "axis0011": {
			AXIS account = axisService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				axisDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "federal0012": {
			FEDERAL account = federalService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				federalDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "hdfc0013": {
			HDFC account = hdfcService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				hdfcDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "icici0014": {
			ICICI account = iciciService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				iciciDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "pnb0015": {
			PNB account = pnbService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				pnbDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "sbi0016": {
			SBI account = sbiService.findById(id);
			if (amount <= user.getBalance()) {
				account.setBalance(account.getBalance() + amount);
				sbiDao.save_account(account);
				user.setBalance(user.getBalance() - amount);
				dao.save_account(user);
				flag = true;
			} else
				return flag = false;

			break;
		}

		}

		return flag;
	}

	public boolean transferMoney(long mobile1, long mobile2, double amount) {
		Wallet user1 = service.findByMobile(mobile1);
		Wallet user2 = service.findByMobile(mobile2);

		boolean flag = true;

		if (amount <= user1.getBalance()) {
			user1.setBalance(user1.getBalance() - amount);
			dao.save_account(user1);
			user2.setBalance(user2.getBalance() + amount);
			dao.save_account(user2);
			flag = true;
		} else
			flag = false;

		return flag;
	}

}
