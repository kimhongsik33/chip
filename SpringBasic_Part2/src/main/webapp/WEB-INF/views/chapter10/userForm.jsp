<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	String contextPath = request.getContextPath();
%>
<body>
<div align="center">
	<h2>Form Page</h2><hr/>
	<form action="<%=contextPath%>/userInfo" method="post">
		<table border="1" cellpadding="1" cellspacing="0">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" /></td>
			</tr>
			<tr>
				<td>Height</td>
				<td><input type="text" name="height" /></td>
			</tr>
			<tr>
				<td>Weight</td>
				<td><input type="text" name="weight" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="send" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>