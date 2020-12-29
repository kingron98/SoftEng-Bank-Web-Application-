<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.*" %>
<%@ page import="com.example.business.BankAccount" %>
<%@ page import="com.example.business.Customer" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Balance</title>
</head>
<body>

	<h1>Check Balance</h1>
	<c:set var="bankaccount" value="${sessionScope.bankaccount}"/>
	<c:set var="customer" value="${sessionScope.customer}"/>
	<p><b>Viewing Balance for account:</b> <c:out value="${bankaccount.accountId}"/></p>
	<p><b>Linked Bank Card:</b> <c:out value="${customer.linkedBankCard}"/></p>
	<p><b>Balance:</b> $<c:out value="${bankaccount.balance}"/></p>
	<br/>
	<br/>
	<a href="loginSuccess.jsp">Click here to return to main menu page.</a>
	
</body>
</html>