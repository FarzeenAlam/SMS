<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
	<legend style="font-size:35px;">Enter Details to Add a Course</legend>
	<label style="font-size:20px;">Enter Course Title:</label><br>
	<input type = "text" name="CourseTitle" required><br><br>
	
	<label style="font-size:20px;">Enter Credit Hours:</label><br>
	<input type = "number" name="CreditHours" required><br><br>
	
	<label style="font-size: 20px;">Enter Department Name:</label> 
					<select style="font-size: 20px;" name="departmentName" required>
						<c:forEach items="${dept}" var="course">
							<option value="${course.departmentName}" >${course.departmentName}
							</option>
						</c:forEach>
					</select><br><br>
	
	<input type = "submit" value="Add" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>
</body>
</html>