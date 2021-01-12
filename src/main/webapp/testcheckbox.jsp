<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
<c:forEach items="${dept}" var="course">
<input type="checkbox" id="vehicle1" name="${course.departmentName}" value="${course.departmentName}">
  <label for="${course.departmentName}">${course.departmentName}</label><br>
</c:forEach> 
</form>
</body>
</html>