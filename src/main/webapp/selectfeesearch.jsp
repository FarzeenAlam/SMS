<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select Type</title>
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
.btn1{
  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
  border: none;
  width: 150px;
  color: white;
	padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.btn2{
box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
  border: none;
  width: 150px;
  color: white;
	padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
</head>
<body>
	<header>
	<h2>What will you provide?</h2>
	</header>
	<br>
	
	<div class="myDiv">
	<form action="byID">
	<input type="submit" style="background-color: #4CAF50;"
	class="btn1" value = "Fee ID" name="add"/>
	</form>
 	</div>
<br>
<br>
<br>
	<div class="myDiv">
  	<form action="byInvoice">
	<input type="submit" style="background-color: #008CBA;" 
	class="btn2" value = "Invoice" name="edit"/><br>
	</form>
	</div>
<br>
<br>
<br>
	<div class="myDiv">
	<form action="byDate">
	<input type="submit" style="background-color: #e7e7e7;" 
  	class="btn1" value = "Date" name="search"/><br>
  	</form>
	</div>
	<br>
<br>
<br>
	<div class="myDiv">
	<form action="byStatus">
	<input type="submit" style="background-color: #555555;" 
 	class="btn2" value = "Status/Course" name="delete"/><br>
  	</form>
	</div>
</body>
</html>