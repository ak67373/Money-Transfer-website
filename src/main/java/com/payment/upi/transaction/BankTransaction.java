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
import com.payment.upi.service.AXISBankServiceImpl;
import com.payment.upi.service.FederalBankServiceImpl;
import com.payment.upi.service.HDFCBankServiceImpl;
import com.payment.upi.service.ICICIBankServiceImpl;
import com.payment.upi.service.PNBBankServiceImpl;
import com.payment.upi.service.SBIBankServiceImpl;

@Service
public class BankTransaction {

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

	public boolean transferMoney(String bankcode1, int id1, double amount, String bankcode2, int id2) {

		boolean flag = true;

		switch (bankcode1) {

		case "axis0011": {
			AXIS account = axisService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				axisDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "federal0012": {
			FEDERAL account = federalService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				federalDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "hdfc0013": {
			HDFC account = hdfcService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				hdfcDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "icici0014": {
			ICICI account = iciciService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				iciciDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "pnb0015": {
			PNB account = pnbService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				pnbDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}
		case "sbi0016": {
			SBI account = sbiService.findById(id1);
			if (amount <= account.getBalance()) {
				account.setBalance(account.getBalance() - amount);
				sbiDao.save_account(account);
				flag = true;
			} else
				return flag = false;

			break;
		}

		}

		if (flag == false)
			return flag;

		switch (bankcode2) {

		case "axis0011": {
			AXIS account = axisService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			axisDao.save_account(account);

			break;
		}
		case "federal0012": {
			FEDERAL account = federalService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			federalDao.save_account(account);

			break;
		}
		case "hdfc0013": {
			HDFC account = hdfcService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			hdfcDao.save_account(account);

			break;
		}
		case "icici0014": {
			ICICI account = iciciService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			iciciDao.save_account(account);

			break;
		}
		case "pnb0015": {
			PNB account = pnbService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			pnbDao.save_account(account);

			break;
		}
		case "sbi0016": {
			SBI account = sbiService.findById(id2);
			account.setBalance(account.getBalance() + amount);
			sbiDao.save_account(account);

			break;
		}

		}

		return flag;
	}
}
