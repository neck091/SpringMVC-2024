<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<table class="iolist list">

	<thead>
		<tr>
			<th>No</th>
			<th>일자</th>
			<th>시각</th>
			<th>거래구분</th>
			<th>상품명</th>
			<th>매입단가</th>
			<th>판매단가</th>
			<th>수량</th>
			<th>매입합계</th>
			<th>매출합계</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${IOLIST}" var="IO" varStatus="INDEX">
			<tr data-seq="${IO.io_seq}"
			class=""
			>
				<td>${INDEX.count}</td>
				<td>${IO.io_date}</td>
				<td>${IO.io_time}</td>
				<td>${IO.io_inout}</td>
				<td>${IO.io_pname}</td>


				<td class="number"><fmt:formatNumber value="${IO.io_iprice}"
						pattern="#,###" /></td>
				<td class="number"><fmt:formatNumber value="${IO.io_oprice}"
						pattern="#,###" /></td>


				<td class="number">${IO.io_quan}</td>


				<td class="number"><fmt:formatNumber value="${IO.io_itotal}"
						pattern="#,###" /></td>
				<td class="number"><fmt:formatNumber value="${IO.io_ototal}"
						pattern="#,###" /></td>
		</c:forEach>
	</tbody>
</table>

<div class="iolist btn_box">
	<a href="${rootPath}/iolist/insert">추가</a>
</div>