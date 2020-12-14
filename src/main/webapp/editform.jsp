<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Account</title>
<style>
header{
background-color:#666;
padding:30px;
text-align:center;
font-size:35px;
color:white;
}
.myDiv{
text-align: center;
}
</style>
</head>
<body>

	<header>
	<h2>Update an account</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="update" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Update details</legend>
	
	<label style="font-size:20px;">Enter name:</label><br>
	<input type = "text" name="Name" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Enter email:</label><br>
	<input type = "email" name="Email" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Enter password:</label><br>
	<input type = "password" name="Password" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Choose account type:</label>
	
	<select style="font-size:17px;" name="AccountType">
	
	<option value="Admin">Admin</option>
	<option value="Student">Student</option>
	<option value="Teacher">Teacher</option>
	
	</select>
	<br><br>
	
	<input type = "submit" value="Update" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>