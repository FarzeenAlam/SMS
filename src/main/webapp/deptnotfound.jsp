<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department not found</title>
<style>
.myDiv {
  border: 5px outset black;
  background-color: red;    
  text-align: center;
  font-size:35px;
}
.btndiv{
 text-align: center;
 font-size: 25px;
}
</style>
</head>
<body>
<div class="myDiv">DEPARTMENT NOT FOUND!</div>
	<div class="btndiv">
	<br><br>
	<form action="gotoadminstart" method="post">
		<input type="submit" value="Return"
			style="text-align: center; padding: 8px 16px; font-size: 100%; display: inline-block;">
	</form>
	</div>

</body>
</html>