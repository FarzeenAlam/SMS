<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice according to date</title>
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
	<h2>Invoice Details</h2>
	</header>
	<div class="myDiv">
	Amount = ${fee}
	Transaction Type = ${tt}
	${course}
	</div>
</body>
</html>