<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Fee</title>
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
	<h2>Add Fee Record</h2>
	</header>
<br>
	<div class="myDiv">

	<form action="addedfee" method="post">
	<fieldset>
	<legend style="font-size:35px;">Add fee details</legend>
	<label style="font-size: 20px;">Student Id:</label> 
					<select style="font-size: 20px;" name="studentId" required>
						<c:forEach items="${ids}" var="course">
							<option value="${course.studentId}" >${course.studentId}
							</option>
						</c:forEach>
					</select><br><br>
	<label style="font-size:20px;">Enter the amount:</label><br>
	<input type = "number" name="Amount" required style="padding: 8px 32px;"><br><br>
	<label style="font-size:20px;">Choose transaction type:</label>
	
	<select style="font-size:17px;" name="TransactionType">
	
	<option value="Cash">Cash</option>
	<option value="Card">Card</option>
	<option value="Online">Online</option>
	
	</select>
	<br><br>
	<label style="font-size:20px;">Course 1 Id:</label><br>
	<input type = "number" name="coursesList" required style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Course 2 Id:</label><br>
	<input type = "number" name="coursesList" style="padding: 8px 32px;"><br><br>
	
	<label style="font-size:20px;">Course 3 Id:</label><br>
	<input type = "number" name="coursesList" style="padding: 8px 32px;"><br><br>
	
	<input type = "submit" value="Add" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	<input type = "reset" style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	
	</fieldset>
	</form>
	</div>

</body>
</html>