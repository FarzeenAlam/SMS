<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Department</title>
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
	<h2>Edit Department</h2>
	</header>
<br>
	<div class="myDiv">
	<form action="editingDepartment" method="post">
	<fieldset>
	<legend style="font-size:35px;">Edit a department</legend>
	<label style="font-size:20px;">Enter department id:</label><br>
	<input type = "number" name="DepartmentId" required><br><br>
	<label style="font-size:20px;">Enter department name:</label><br>
	<input type = "text" name="DepartmentName" required><br>
	
	<input type = "submit" value="Update" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>