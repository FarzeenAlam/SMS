<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Student Id</title>
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
		<h2>Student Selection</h2>
	</header>

	<div class="myDiv">

		<form action="afterstudentid" method="post">


			<fieldset>
				<legend style="font-size: 35px;">Select Student Id</legend>
				<div class="myDiv">
					<label style="font-size: 20px;">Student Id:</label> 
					<select style="font-size: 20px;" name="studentId" required>
						<c:forEach items="${ids}" var="course">
							<option value="${course.studentId}" >${course.studentId}
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