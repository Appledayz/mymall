<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item List</title>
</head>
<body>
	<h1>Item List</h1>
	<!-- 주문하기 item pk, member pk -->
	<table>
		<tr>
			<td>상품번호</td><td>상품명</td><td>상품가격</td>
		</tr>
		<c:forEach var="item" items="itemList">
			<tr>
				<td>${item.no}</td>${item.name}<td></td><td>${item.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>