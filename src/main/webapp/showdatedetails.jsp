<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
table, th, td {
  border: 1px solid black;
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
		<table class="myDiv" style="width:100%">
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
				<c:forEach items="${feedetail}" var="fee">
					<tr>
						<td><c:out value="${fee.studentId}"/></td>
						<td><c:out value="${fee.courseTitle}"/></td>
						<td><c:out value="${fee.amount}"/></td>
						<td><c:out value="${fee.dateTime}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>