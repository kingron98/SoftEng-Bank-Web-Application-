package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.BankAccount;
import com.example.business.Customer;
import com.example.service.CustomerService;

public class TransferFundsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
			
		CustomerService customerService = new CustomerService();
		String forwardToJsp = "";		

		String uNameRecp = request.getParameter("accountId");
		String amountStr = request.getParameter("amount");
		
		double amount = 0;
		
		if (amountStr.isEmpty()) {
			amountStr = "0";
		}else {
			amount = Double.parseDouble(amountStr);
		}
		
		Customer c = (Customer) request.getSession().getAttribute("customer");
		BankAccount ac = (BankAccount) request.getSession().getAttribute("bankaccount");
		
		String uName = c.getUserId();
		double custBalance = ac.getBalance();
		
		int r[] = null;
		boolean flag = false;

		// Check we have username and amount
		if (uNameRecp != null && amountStr != null){
			
			BankAccount recp = customerService.getBankAccount(uNameRecp);
			// Check if amount not 0 and bank account exists
			if (amount == 0 || recp == null || custBalance < amount || recp.getAccountId().equals(uName)) {
				forwardToJsp = "/transferFailure.jsp";
			}
			else {
				r = customerService.transfer(uNameRecp, amount, uName, custBalance);
				
				for (int i = 0; i < r.length; i++) {
					if (r[i] == 1) {
						flag = true;
					}else {
						flag = false;
					}
				}
				
				if (flag) {
					ac.setBalance(custBalance - amount);
					forwardToJsp = "/transferSuccess.jsp";
				}
				else {
					forwardToJsp = "/transferFailure.jsp";
				}
			}
		}
		else {
			forwardToJsp = "/transferFailure.jsp";	
		}
		return forwardToJsp;
	}

}
