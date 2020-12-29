<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LZ Bank Web Application Main Menu</title>
</head>

<body>

	<h1>LZ Bank Web Application Main Menu</h1>
	
	<br/>
	
	<c:set var="customer" value="${sessionScope.customer}"/>
	<c:set var="bankaccount" value="${sessionScope.bankaccount}"/>
	<h2>Welcome back,</h2>
	<br/>
	<h3><c:out value="${customer.customerName}"/></h3>
	<br/><br/>
	<b>What would like to do?</b>
	
	<br/><br/>
	
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="ViewUserProfile" />
         <input type="submit" value="View My Profile" />
    </form>  
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="CheckBalance" />
         <input type="submit" value="Check Balance" />
    </form>   
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="DisplayUpdateProfile" />
         <input type="submit" value="Update Profile" />
    </form>
    <form action="FrontController" method="post">
	     <input type="hidden" name="action" value="DisplayTransferFunds" />
         <input type="submit" value="Transfer Funds" />
    </form>
    
</body>

</html>