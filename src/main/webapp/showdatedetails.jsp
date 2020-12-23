<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice according to date</title>
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
	font-size: 25px;
}
</style>
</head>
<body>
	<header>
		<h2>Invoice Details</h2>
	</header>
	<div class="myDiv">
		<table class="table table-striped">
			<caption>
				<h3>FeeLog Detail</h3>
			</caption>
			<thead>
				<tr>
					<td>Student Id</td>
					<td>Course Title</td>
					<td>Amount</td>
					<td>Date Time</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${feedetail}" var="feedetail">
					<tr>
						<td>${feedetail.StudentId}</td>
						<td>${feedetail.CourseTitle}</td>
						<td>${feedetail.Amount}</td>
						<td>${feedetail.DateTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>