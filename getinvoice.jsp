<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Invoice</title>
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
	<h2>Check Invoice</h2>
	</header>
<br>
	<div class="myDiv">
	<form action="checkingInvoice" method="post">
	<fieldset>
	<legend style="font-size:35px;">Check Courses Against Invoice</legend>
	<label style="font-size:20px;">Enter invoice id:</label><br>
	<input type = "text" name="InvoiceId" required><br><br>
	
	<input type = "submit" value="Check" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>