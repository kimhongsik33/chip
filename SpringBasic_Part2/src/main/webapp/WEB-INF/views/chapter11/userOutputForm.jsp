<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2>${msg}</h2>
<hr />

<form action="userView">
	<table border="1" cellpadding="2" cellspacing="0">
	  <tr>
	  	<td>Name</td>
	  	<td>${userDto.userName}</td>
	  </tr>
	  <tr>
	  	<td>Address</td>
	  	<td>${userDto.address}</td>
	  </tr>
	  <%-- <tr>
	  	<td>Car</td>
	  	<td>
		  	<c:forEach var="car" items="${hitCar}">
		  		${car},&nbsp;
		  	</c:forEach>
	  	</td>
	  </tr> --%>
	</table>
	
	<input type="submit" value="Move To View"/>
</form>
</div>
</body>
</html>