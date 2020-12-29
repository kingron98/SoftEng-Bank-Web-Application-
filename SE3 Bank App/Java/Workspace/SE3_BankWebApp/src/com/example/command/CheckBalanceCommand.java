package com.example.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.BankAccount;
import com.example.business.Customer;
import com.example.service.CustomerService;

public class CheckBalanceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response){
			
		String forwardToJsp = "";		
		
		forwardToJsp = "/checkBalance.jsp";				
		
		return forwardToJsp;
	}
}

