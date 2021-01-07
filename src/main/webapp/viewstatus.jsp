<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Record</title>
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
		<h2>Fee Records</h2>
	</header>
	
	<div class="myDiv">
		<table class="myDiv" style="width:100%">
			<caption>
				<h3>Fee Data Per Student Status</h3>
			</caption>
			<thead>
				<tr>
					<td>Student Id</td>
					<td>Submission Date</td>
					<td>Expire Date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${display}" var="bean">
					<tr>
						<td><c:out value="${bean.studentId}"/></td>
						<td><c:out value="${bean.lastFee}"/></td>
						<td><c:out value="${bean.expiry}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>