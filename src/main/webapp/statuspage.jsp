<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record per Status</title>
<style>
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

.myDiv {
	text-align: center;
}
</style>
</head>
<body>
	<header>
		<h2>View Record per Active Students</h2>
	</header>
	<br>
	<div class="myDiv">
		<form action="viewstatus" method="post">
			<fieldset>
				<legend style="font-size: 35px;">Choose your options and
					click Display</legend>
				<label style="font-size: 20px;">Choose course status:</label> 
				<input type="radio" id="active" name="courseStatus" value="true" required="required">
				<label for="active">Active</label> 
				<input type="radio" id="deactive" name="courseStatus" value="false"> 
				<label for="deactive">Deactivated</label><br><br>
				
				<label style="font-size: 20px;">Course Name:</label>
				<select name="courseTitle" id="courseTitle" required >
				<c:forEach items="${courses}" var="course">
				<option value="${courses}">${course.courseTitle}</option>
				</c:forEach>
				</select>
				<br><br>
				<input type="submit" value="Display"
					style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
				

			</fieldset>
		</form>
	</div>


</body>
</html>