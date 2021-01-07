<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
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
	<h2>Student Information Entry</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="addingStudent" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Add student information</legend>
	
	<label style="font-size:20px;">Enter name:</label><br>
	<input type = "text" name="StudentName" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size: 20px;">Course Name:</label>
				<select style="font-size: 20px;" name="courseTitle" id="courseTitle" required >
				<c:forEach items="${courses}" var="course">
				<option value="${course.courseTitle}">${course.courseTitle}</option>
				</c:forEach>
				</select>
	<br><br>
	
	<label style="font-size:20px;">Select Student Status:</label>	
	<input type="radio" id="active" name="StudentStatus" value="true" required="required">
	<label style="font-size: 20px;" for="active">Active</label> 
	<input type="radio" id="deactive" name="StudentStatus" value="false"> 
	<label style="font-size: 20px;" for="deactive">Deactivated</label><br><br>
	
	<input type = "submit" value="Enter" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>