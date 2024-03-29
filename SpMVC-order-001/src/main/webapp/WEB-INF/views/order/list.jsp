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
		<table class="w3-table-all w3_ w3-hoverable">
			<tr>
				<th>주문코드</th>
				<th>주문날짜</th>
				<th>주문고객</th>
				<th>고객이름</th>
				<th>고객전번</th>


			</tr>
			<c:forEach items="${ORDER_LIST}" var="ORDER" varStatus="VAR">
				<tr>
					<td>${ORDER.o_num}</td>
					<td>${ORDER.o_date}</td>
					<td>${ORDER.c_code}</td>
					<td>${ORDER.c_name}</td>
					<td>${ORDER.c_tel}</td>
				</tr>
			</c:forEach>

		</table>
		<div class="w3-container  btn-box">
			<a href="${rootPath}/order/input"
				class="w3-button w3-blue w3-round-large">추가</a>
		</div>

	</div>
</body>
</html>