<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
*{
box-sizing: border-box;
}
body{
font-family: Arial, Helvetica, sans-serif;
}
header{
background-color:#666;
padding:30px;
text-align:center;
font-size:35px;
color:white;
}
nav{
float:left;
width:30px;
background:#ccc;
paddig:20px;
}
article{
float:left;
padding:20px;
width:70%;
background-color:#f1f1f1;
}
section:after{
content:"";
display:table;
clear:both;
}
footer{
background-color:#777;
padding:10px;
text-align:center;
color:white;
}
.myDiv{
text-align: center;
}
</style>
</head>
<body>

	<header>
	<h2>Login</h2>
	</header>
	<br>
	<div class="myDiv">
	<form action="login">
	<br>
	<input type="email" name="Email" placeholder="Email here" required style="padding: 15px 32px;"><br>

	<br>
	<input type="password" name="Password" placeholder="Password here" required style="padding: 15px 32px;"><br>
	<br>
	<input type="submit" value="Login" style="text-align: center; padding: 15px 32px; font-size: 120%; display: inline-block; box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);">
	</form>
	</div>

</body>
</html>