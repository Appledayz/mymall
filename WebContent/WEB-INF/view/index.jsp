<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
	<a href="${pageContext.request.contextPath}/ItemListController">상품목록</a>
	<a href="${pageContext.request.contextPath}/OrderListController">주문목록</a>
	<c:if test="${loginMember == null}">
		<form action="${pageContext.request.contextPath}/LoginController" method="post">
			<table>
				<tr>
					<td>ID : </td><td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>PW : </td><td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td><button type="submit">로그인</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<c:if test="${loginMember != null}">
		<br />
		${loginMember.id} 님 로그인 중...
	</c:if>
</body>
</html>