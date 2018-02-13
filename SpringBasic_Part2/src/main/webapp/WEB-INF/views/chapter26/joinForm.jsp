<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ���� �Է�</title>
</head>
<body>
<div align="center">
<h2>ȸ�� ���� �Է� ��</h2>
<hr width="500" color="blue">
<form:form commandName="member">
	<table border="1" cellpadding="2" cellspacing="0" width="500">
		<tr>
			<td width="20%"><form:label path="id">���̵�</form:label></td>
			<td><form:input path="id"/><form:errors path="id" /></td>
		</tr>
		<tr>
			<td><form:label path="name">�̸�</form:label></td>
			<td><form:input path="name"/><form:errors path="name"/></td>
		</tr>
		<tr>
			<td><form:label path="address.address1">�ּ�1</form:label></td>
			<td>
			   <form:input path="address.address1" />
			   <form:errors path="address.address1" />
			</td>
		</tr>
		
		<tr>
				<td><form:label path="address.address2">�ּ�2</form:label></td>
				<td>
					<form:input path="address.address2" />
					<form:errors path="address.address2" />
				</td>
		</tr>
		<tr>
			<td><form:label path="email">�̸���</form:label></td>
			<td>
				<form:input path="email"/>
				<form:errors path="email" />
			</td>
		</tr>
		
		
		<tr>
			<td><form:label path="job">����</form:label></td>
			<td>
				<form:select path="job">
					<option value="">::::::::: ������ �����ϼ��� ::::::::::</option>
					<form:options items="${jobCodes}" itemLabel ="label" itemValue="code"/>
				</form:select>
				<form:errors path="job" />
			</td>
		</tr>
		
		<tr>
			<td><form:label path="hobbys">���</form:label></td>
			<td>
				<form:checkboxes items="${hobbyNames}" path="hobbys" />
				<form:errors path="hobbys" />
			</td>
		</tr>
		
		<tr>
			<td><form:label path="gender">����</form:label></td>
			<td>
				<form:radiobuttons items="${mw}" path="gender"/>				
			</td>
		</tr>
		
		<tr>
			<td><form:label path="etc">��Ÿ</form:label></td>
			<td>
				<form:textarea path="etc" cols="20" rows="5"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2"><form:checkbox path="contractAgreement" label="����� �����մϴ�" /></td>
		</tr>
	</table>
	<input type="submit" value="ȸ�� ���" />
</form:form>
</div>
</body>
</html>