<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
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
	<h2>Delete a Student Record</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="deletingStudent" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Enter details to delete a student record</legend>
	
	<label style="font-size:20px;">Enter student id:</label><br>
	<input type = "number" name="StudentId" required style="padding: 8px 32px;"><br><br>
	
	<input type = "submit" value="Delete" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>