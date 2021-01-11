<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Fee Record</title>
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
.btndiv{
 text-align: center;
 font-size: 25px;
}
</style>
</head>
<body>
	<header>
	<h2>Fee Details</h2>
	</header>
	<div class="myDiv">
	${fee}
	</div>
	<div class="btndiv">
	<br><br>
	<form action="back" method="post">
		<input type="submit" value="Return to Login"
			style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	</form>
	</div>
</body>
</html>