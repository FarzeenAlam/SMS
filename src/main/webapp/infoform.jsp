<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Handling</title>
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
	<h2>Select which information to handle</h2>
	</header>
	
	<br><br>
	<div class="myDiv">
	<form action="building">
	<input type="submit" style="background-color: #4CAF50;"
	class="btn1" value = "Building" name="building"/>
	</form>
 	</div>
<br>
<br>
<br>
	<div class="myDiv">
  	<form action="course">
	<input type="submit" style="background-color: #008CBA;" 
	class="btn2" value = "Course" name="course"/><br>
	</form>
	</div>
<br>
<br>
<br>
	<div class="myDiv">
	<form action="department">
	<input type="submit" style="background-color: #4CAF50;"
	class="btn1" value = "Department" name="department"/>
	</form>
 	</div>
<br>
<br>
<br>
	<div class="myDiv">
	<form action="student">
	<input type="submit" style="background-color: #008CBA;"
	class="btn2" value = "Student" name="student"/>
	</form>
 	</div>
<br>
<br>
<br>
	<div class="myDiv">
	<form action="teacher">
	<input type="submit" style="background-color: #4CAF50;"
	class="btn1" value = "Teacher" name="teacher"/>
	</form>
 	</div>
<br>
<br>
<br>
</body>
</html>