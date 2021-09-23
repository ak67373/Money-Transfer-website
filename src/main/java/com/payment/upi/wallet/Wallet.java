package com.payment.upi.wallet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {

	@Id
	@Column(name = "user_mobile")
	private long mobile;
	@Column(name = "user_name")
	private String name;
	@Column(name = "bank_code")
	private String bankcode;
	@Column(name = "bank_id")
	private int bankId;
	@Column(name = "balance")
	private double balance=0.0;

	public Wallet(String name, long mobile, String bankcode, double balance) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.bankcode = bankcode;
		this.balance = balance;
	}

	public Wallet() {
		super();
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
