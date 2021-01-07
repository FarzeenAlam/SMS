<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Student</title>
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
	<h2>Search a student</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="searchingStudent" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Select Student Id to Search:</legend>
	
	<label style="font-size: 20px;">Student Id:</label>
				<select style="font-size: 20px;" name="studentId" id="studentId" required >
				<c:forEach items="${courses}" var="course">
				<option value="${course.studentId}">${course.studentId}</option>
				</c:forEach>
				</select>
	<br><br>
	
	<input type = "submit" value="Search" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>