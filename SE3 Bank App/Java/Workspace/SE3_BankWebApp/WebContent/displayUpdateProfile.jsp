<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>

	<b>Change your phone number and email here, confirm changes by typing in your password.</b>
	
	<br/><br/>
	
	<form action="FrontController" method="post">
    	<table>
        	<tr>
    			<td> Phone Number  : </td><td> <input name="phoneNumber" size=15 type="text" /> </td> 
    		</tr>
            <tr>
            	<td> Email  : </td><td> <input name="email" size=15 type="text" /> </td> 
            </tr>
            <tr>
                <td> Confirm Password  : </td><td> <input name="password" size=15 type="password" /> </td> 
            </tr>
        </table>
                
        <input type="hidden" name="action" value="UpdateProfile" />
        <input type="submit" value="Update" />
    </form>
    <br/>
	<br/>
	<a href="loginSuccess.jsp">Click here to return to main menu page.</a>

</body>
</html>