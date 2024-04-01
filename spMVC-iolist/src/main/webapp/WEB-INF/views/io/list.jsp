<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">

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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/io.js?111"></script>
<body>


	<div class="w3-container w3-padding-24 w3-center">
		<table class="w3-table-all w3_ w3-hoverable">
			<thead>
			<tr>
				<th>No</th>
				<th>일자</th>
				<th>시각</th>
				<th>상품명</th>
				<th>매입단가</th>
				<th>판매단가</th>
				<th>수량</th>
				<th>매입합계</th>
				<th>판매합계</th>
			</tr>
		</thead>
		<tbody class="io_body">
			<c:set var="totalPurchase" value="0" />
			<c:set var="totalSales" value="0" />
			<c:forEach items="${IO_LIST}" var="IO" varStatus="VAR">
				<tr data-seq="${IO.seq}">
					<td>${VAR.count}</td>
					<td>${IO.io_date}</td>
					<td>${IO.io_time}</td>
					<td>${IO.io_pname}</td>
					<td>${IO.io_input == 1 ? IO.io_price : ''}</td>
					<td>${IO.io_input == 2 ? IO.io_price : ''}</td>
					<td>${IO.io_quan}</td>
					<td>${IO.io_input == 1 ? IO.io_quan * IO.io_price : ''}</td>
					<td>${IO.io_input == 2 ? IO.io_quan * IO.io_price : ''}</td>
				</tr>
				<c:if test="${IO.io_input == 1}">
					<c:set var="totalPurchase" value="${totalPurchase + (IO.io_quan * IO.io_price)}" />
				</c:if>
				<c:if test="${IO.io_input == 2}">
					<c:set var="totalSales" value="${totalSales + (IO.io_quan * IO.io_price)}" />
				</c:if>
			</c:forEach>
			<tr>
				<td colspan="7"><strong>합계</strong></td>
				<td>${totalPurchase}</td>
				<td>${totalSales}</td>
			</tr>
		</tbody>
		</table>
		<div class="w3-container  btn-box">
			<a href="${rootPath}/insert" class="w3-button w3-blue w3-round-large">추가</a>
		</div>
	</div>
</body>
</html>