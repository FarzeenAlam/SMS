<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Student</title>
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
font-size:25px;
}
</style>
</head>
<body>
	<header>
	<h2>Student Details</h2>
	</header>
	<div class="myDiv">
	${student}
	</div>

</body>
</html>