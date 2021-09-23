package com.payment.upi.Banks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hdfc")
public class HDFC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "user_mobile")
	private long mobile;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_age")
	private int age;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_aadhar")
	private long aadhar_no;
	@Column(name = "user_balance")
	private double balance;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bankcode")
	private String bankcode = "hdfc0013";

	public HDFC(long mobile, String name, int age, String email, long aadhar_no, double balance, String bankcode) {
		this.mobile = mobile;
		this.name = name;
		this.age = age;
		this.email = email;
		this.aadhar_no = aadhar_no;
		this.balance = balance;
		this.bankcode = bankcode;
	}

	public HDFC() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(long aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBank_code() {
		return bankcode;
	}

}
