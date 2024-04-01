<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<style>
div.w3-card-4 {
	width: 50%;
	margin: 20px auto;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>
	const msg = "${MSG}" //msg=""
	if (msg === "NOT") {
		alert("삭제 불가. 관리자 문의 要")
	} else if (msg === "FK") {
		alert("삭제 불가.")
	}
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/io.js?12"></script>
<body>
	<main class="w3-container">
		<div class="w3-card-4 w3-dark-gray">
			<div class="w3-container w3-center">
				<h3>${IO.seq}</h3>
				<h5>${IO.io_date}</h5>
				<h5>${IO.io_time}</h5>
				<h5>${IO.io_pname}</h5>
				<h5>${IO.io_input == 1 ? '매입' : '매출'}</h5>
				<h5>${IO.io_price}</h5>
				<h5>${IO.io_quan}</h5>
				<h5>${IO.io_quan *IO.io_price}</h5>
				<div class="w3-section">
					<input data-seq="${IO.seq}" type="button" value="수정"
						class="btn_update w3-button w3-green"> <input
						data-seq="${IO.seq}" type="button" value="삭제"
						class="btn_delete w3-button w3-red">
				</div>
			</div>
		</div>
	</main>

</body>
</html>