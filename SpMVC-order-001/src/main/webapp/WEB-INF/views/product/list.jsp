<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/includes/head.jspf"%>
<style>
table.w3-table-all {
	width: 70%;
	margin: 10px auto;
}

div.btn-box {
	display: block;
	width: 70%;
	margin: 5px auto;
	text-align: right;
	padding: 0;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jspf"%>

	<div class="w3-container w3-padding-24 w3-center">
		<div class="w3-container  btn-box">
			<a href="${rootPath}/product/insert"
				class="w3-button w3-blue w3-round-large">상품추가</a>
		</div>
		<table class="w3-table-all w3_ w3-hoverable">
			<tr>
				<th>상품코드</th>
				<th>상품이름</th>
				<th>규격</th>
				<th>가격</th>


			</tr>
			<c:forEach items="${PRO_LIST}" var="PRO" varStatus="VAR">
				<tr>
					<td>${PRO.p_code}</td>
					<td>${PRO.p_name}</td>
					<td>${PRO.p_item}</td>
					<td>${PRO.p_price}</td>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>