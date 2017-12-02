<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Form</title>
</head>
<body>
<div align="center">
	<hr width="400" color="red"/>
	<h2>Input Personal Information</h2>
	<hr width="400" color="red"/>
	
	<form action="person" method="post">
	  Name : <input type="text" name="name" /><br/>
	  ID   : <input type="text" name="id" /><br/>
	  <input type="submit" value="send" />
	</form>
</div>
</body>
</html>