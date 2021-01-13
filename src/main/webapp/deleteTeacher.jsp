<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Teacher Profile</title>
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
	<h2>Delete a Teacher Profile</h2>
	</header>
	
	<div class="myDiv">
	
	<form action="deletingTeacher" method="post">
	
	<fieldset>
	<legend style="font-size:35px;">Enter details to delete a teacher profile</legend>
	
	<label style="font-size: 20px;">Instructor Id:</label>
				<select style="font-size: 20px;" name="instructorId" id="instructorId" required >
				<c:forEach items="${courses}" var="course">
				<option value="${course.instructorId}">${course.instructorId}</option>
				</c:forEach>
				</select>
	<br><br>	
	<input type = "submit" value="Delete" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>