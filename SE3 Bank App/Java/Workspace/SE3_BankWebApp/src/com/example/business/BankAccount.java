package com.example.business;

import java.io.Serializable;

public class BankAccount implements Serializable{


	private static final long serialVersionUID = 1L;
	private String accountId;
	private double balance;
	private String accountHolder;
	
	public BankAccount(String accountId, double balance, String accountHolder) {
		setAccountId(accountId);
		setBalance(balance);
		setAccountHolder(accountHolder);
	}
	
	public BankAccount() {
		super();
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
}
