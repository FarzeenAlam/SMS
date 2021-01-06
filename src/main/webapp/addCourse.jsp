<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
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
	<h2>Add Course</h2>
	</header>
<br>
	<div class="myDiv">
	<form action="addingCourse" method="post">
	<fieldset>
	<legend style="font-size:35px;">Enter details to add a course</legend>
	<label style="font-size:20px;">Enter course title:</label><br>
	<input type = "text" name="CourseTitle" required><br><br>
	
	<label style="font-size:20px;">Enter credit hours:</label><br>
	<input type = "number" name="CreditHours" required><br><br>
	
	<label style="font-size:20px;">Enter department id:</label><br>
	<input type = "number" name="department" required><br><br>
	
	<input type = "submit" value="Add" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>