<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
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
	<h2>Teacher Information Entry</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="addingTeacher" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Add teacher information</legend>
	
	<label style="font-size:20px;">Enter name:</label><br>
	<input type = "text" name="InstructorName" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Enter salary:</label><br>
	<input type = "number" name="Salary" required style="padding: 8px 32px;">
	<br><br>
	
	<label style="font-size: 20px;">Course Name:</label>
				<select style="font-size: 20px;" name="courseTitle" id="courseTitle" required >
				<c:forEach items="${courses}" var="course">
				<option value="${course.courseTitle}">${course.courseTitle}</option>
				</c:forEach>
				</select>
	<br><br>
	
	<input type = "submit" value="Enter" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>