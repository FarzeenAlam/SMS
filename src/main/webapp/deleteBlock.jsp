<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Block</title>
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
	<h2>Delete a Block</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="deletingBlock" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Enter details to delete a block</legend>
	
	<label style="font-size:20px;">Enter Building Name:</label><br>
	<input type = "text" name="BuildingName" required style="padding: 8px 32px;"><br><br>
	
	<input type = "submit" value="Delete" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>