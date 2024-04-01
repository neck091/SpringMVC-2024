<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>여기는 제목</title>

</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
	<h1>매입매출등록</h1>
	<h3>${MSG}</h3>
	<form method="POST">
		<c:choose>
			<c:when test="${empty IO}">
				<%
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				String currentDate = sdfDate.format(new Date());
				%>

				<%
				SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
				String currentTime = sdfTime.format(new Date());
				%>
				<div>
					<input class="w3-input w3-border" placeholder="일자" type="date" name="io_date"
						value="<%=currentDate%>" />
				</div>
				<div>
					<input  class="w3-input w3-border" placeholder="시간" type="time" name="io_time"
						value="<%=currentTime%>" />
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<input class="w3-input w3-border" placeholder="일자" type="date" name="io_date"
						value="${IO.io_date}" />
				</div>
				<div>
					<input class="w3-input w3-border" placeholder="시간" type="time" name="io_time"
						value="${IO.io_time}" />
				</div>
			</c:otherwise>
		</c:choose>
		<div>
			<input class="w3-input w3-border" placeholder="상품명" name="io_pname" value="${IO.io_pname}" />
		</div>
		<div>
			<select name="io_input" class="w3-input w3-border" >
				<option value="1" ${IO.io_input == 1 ? 'selected' : ''}>매입</option>
				<option value="2" ${IO.io_input == 2 ? 'selected' : ''}>매출</option>
			</select>
		</div>
		<div>
			<input class="w3-input w3-border" placeholder="단가" name="io_price" value="${IO.io_price}" />
		</div>
		<div>
			<input class="w3-input w3-border" placeholder="수량" name="io_quan" value="${IO.io_quan}" />
		</div>

		<div>
			<input class="w3-button w3-block w3-green w3-section w3-padding" type="submit" value="저장" />
		</div>
	</form>
</body>
</html>