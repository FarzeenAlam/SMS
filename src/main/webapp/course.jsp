<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Handling</title>
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
	<h2>Course Handling</h2>
	</header>
	<br>
	
	<div class="myDiv">
	<form action="addCourse">
	<input type="submit" style="background-color: #4CAF50;"
	class="btn1" value = "Add" name="add"/>
	</form>
 	</div>
<br>
<br>
<br>
	<div class="myDiv">
  	<form action="editCourse">
	<input type="submit" style="background-color: #008CBA;" 
	class="btn2" value = "Update" name="edit"/><br>
	</form>
	</div>
<br>
<br>
<br>
	<div class="myDiv">
	<form action="searchCourse">
	<input type="submit" style="background-color: #e7e7e7;" 
  	class="btn1" value = "Search" name="search"/><br>
  	</form>
	</div>
	<br>
<br>
<br>
	<div class="myDiv">
	<form action="deleteCourse">
	<input type="submit" style="background-color: #555555;" 
 	class="btn2" value = "Delete" name="delete"/><br>
  	</form>
	</div>
</body>
</html>