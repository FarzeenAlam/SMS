<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Courses</title>
<style>
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}
table, th, td {
  border: 1px solid black;
}
.myDiv {
	text-align: center;
	font-size: 25px;
}
.btndiv{
 text-align: center;
 font-size: 25px;
}
</style>
</head>
<body>
	<header>
		<h2>Courses</h2>
	</header>
	
	<div class="myDiv">
		<table class="myDiv" style="width:100%">
			<caption>
				<h3>Courses Detail</h3>
			</caption>
			<thead>
				<tr>
					<td>Course Id</td>
					<td>Course Title</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${courses}" var="bean">
					<tr>
						<td><c:out value="${bean.courseId}"/></td>
						<td><c:out value="${bean.courseTitle}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
	<div class="btndiv">
	<br><br>
	<form action="gotoadminstart" method="post">
		<input type="submit" value="Return to Admin"
			style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	</form>
	<br><br>
	<form action="back" method="post">
		<input type="submit" value="Return to Login"
			style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	</form>
	</div>
</body>
</html>