<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer Funds</title>
</head>
<body>

	<b>Transfer Funds to a 3rd party account just by entering their Username.</b>
	
	<br/><br/>
	
	<form action="FrontController" method="post">
    	<table>
        	<tr>
    			<td> Bank Account ID(Username)  : </td><td> <input name="accountId" size=15 type="text" /> </td> 
    		</tr>
            <tr>
            	<td> Amount  : </td><td> <input name="amount" size=15 type="number" /> </td> 
            </tr>
        </table>
                
        <input type="hidden" name="action" value="TransferFunds" />
        <input type="submit" value="Transfer" />
    </form>
    <br/>
	<br/>
	<a href="loginSuccess.jsp">Click here to return to main menu page.</a>

</body>
</html>