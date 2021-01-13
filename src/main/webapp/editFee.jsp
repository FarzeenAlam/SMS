<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Fee Record</title>
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
	<h2>Edit Fee Record</h2>
	</header>
<br>
	<div class="myDiv">

	<form action="updatefee" method="post">
	<fieldset>
	<legend style="font-size:35px;">Enter details to edit fee record</legend>
	<label style="font-size:20px;">Enter Fee id:</label><br>
	<input type = "number" name="FeeId" required style="padding: 8px 32px;"><br><br>
	<label style="font-size:20px;">Enter the amount:</label><br>
	<input type = "number" name="Amount" required style="padding: 8px 32px;"><br><br>
	<label style="font-size:20px;">Choose transaction type:</label>
	
	<select style="font-size:17px;" name="TransactionType" required>
	
	<option value="Cash">Cash</option>
	<option value="Card">Card</option>
	<option value="Online">Online</option>
	
	</select>
	<br><br>
	
	<input type = "submit" value="Update" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>

</body>
</html>