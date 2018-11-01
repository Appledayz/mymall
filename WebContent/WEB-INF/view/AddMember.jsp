<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Member</title>
</head>
<body>
	<h1>AddMember</h1>
	<form action="${pageContext.request.contextPath}/AddMemberController" method="post">
		<table>
			<tr>
				<td>ID : </td><td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>PW : </td><td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td><button type="submit">회원가입</button></td>
			</tr>
		</table>
	</form>
</body>
</html>