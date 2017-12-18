<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>member info</h2>

<form:form action="ch22AddMember" method="post">
	<table>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>PhoneNumber</td>
			<td><form:input path="hp" /></td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="submit"/>
			</td>
		</tr>
	</table>
</form:form>


</body>
</html>