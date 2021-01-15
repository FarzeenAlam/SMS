<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Handling</title>
</head>
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
<body>
<header>
	<h2>Profile Handling</h2>
	</header>
	
	<div class="myDiv">
	<form action="addingBlock" method="post">
	<fieldset>
		<img id="image-1" alt="" src="src/main/images/1e109b17072b14c003c14304a5746d25.jpg" width="200" height="100"/>
			<br><br>
		<label style="font-size:20px;">Enter First Name:</label><br>
	<input type = "text" name="firstName" required><br><br>
	<label style="font-size:20px;">Enter Second Name:</label><br>
	<input type = "text" name="secondName" required><br><br>
	<br><br>
		<input type = "reset" value="Cancel" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">	
		<input type = "submit" value="Save" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">		
		</fieldset>
	</form>
	</div>
</body>
</html>