package com.example.business;

import java.io.Serializable;

public class Customer implements Serializable{


	private static final long serialVersionUID = 1L;
	private String userId;
	private String password;
	private String customerName;
	private String phoneNumber;
	private String linkedBankCard;
	private String email;
	
	public Customer(String userId, String password, String customerName, 
			String phoneNumber, String linkedBankCard, String email) {
		
		setUserId(userId);
		setPassword(password);
		setCustomerName(customerName);
		setPhoneNumber(phoneNumber);
		setLinkedBankCard(linkedBankCard);
		setEmail(email);
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLinkedBankCard() {
		return linkedBankCard;
	}

	public void setLinkedBankCard(String linkedBankCard) {
		this.linkedBankCard = linkedBankCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
