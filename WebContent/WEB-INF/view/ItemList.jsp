<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<style>
		span{
			margin:0 1px 0 1px;
		}
	</style>
	<title>Item List</title>
</head>
<body>
	<h1>Item List</h1>
	<!-- 주문하기 item pk, member pk -->
	<table border="1">
		<tr>
			<td>상품번호</td><td>상품명</td><td>상품가격</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.no}</td><td>${item.name}</td><td>${item.price}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3" align="center">
				<c:if test="${pagingInfo.pageButtonBegin > 0}">
					<span>
						<a href="${pageContext.request.contextPath}/ItemListController?page=1"><<</a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/ItemListController?page=${pagingInfo.pageButtonBegin}"><</a>
					</span>
				</c:if>
				<c:forEach var="i" begin="1" end="${pagingInfo.pageButtonPerPage}" step="1">
					<c:if test="${pagingInfo.currentPage == pagingInfo.pageButtonBegin+i}">
						<span>
							${pagingInfo.pageButtonBegin+i}
						</span>
					</c:if>
					<c:if test="${pagingInfo.currentPage != pagingInfo.pageButtonBegin+i}">
						<span>
							<a href="${pageContext.request.contextPath}/ItemListController?page=${pagingInfo.pageButtonBegin+i}">${pagingInfo.pageButtonBegin+i}</a>
						</span>
					</c:if>
				</c:forEach>
				<c:if test="${pagingInfo.pageButtonBegin+pagingInfo.pageButtonPerPage< pagingInfo.lastPage}">
					<span>
						<a href="${pageContext.request.contextPath}/ItemListController?page=${pagingInfo.pageButtonBegin+pagingInfo.pageButtonPerPage+1}">></a>
					</span>
					<span>
						<a href="${pageContext.request.contextPath}/ItemListController?page=${pagingInfo.lastPage}">>></a>
					</span>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>