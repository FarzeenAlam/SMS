<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Department</title>
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
		<h2>Department Selection</h2>
	</header>

	<div class="myDiv">

		<form action="afterdepartment" method="post">


			<fieldset>
				<legend style="font-size: 35px;">Select desired department</legend>
				<div class="myDiv">
					<label style="font-size: 20px;">Department Name:</label> 
					<select style="font-size: 20px;" name="departmentName" required>
						<c:forEach items="${dept}" var="course">
							<option value="${course.departmentId}" >${course.departmentName}
							</option>
						</c:forEach>
					</select>

				</div>
				<br>
				<br> <input type="submit" value="Go"
					style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">

			</fieldset>
		</form>

	</div>
</body>
</html>