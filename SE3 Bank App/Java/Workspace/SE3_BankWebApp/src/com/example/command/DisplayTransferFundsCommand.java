package com.example.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Customer;
import com.example.service.CustomerService;

public class DisplayTransferFundsCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
			
		String forwardToJsp = "";		
		
		forwardToJsp = "/displayTransferFunds.jsp";				
		
		return forwardToJsp;
	}
}


