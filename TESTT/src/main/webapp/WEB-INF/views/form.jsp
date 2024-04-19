<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#nounList').on('click', 'li', function() {
			var noun = $(this).text();
			$.ajax({
				url : '${rootPath}/words',
				type : 'GET',
				data : {
					word : noun
				},
				success : function(response) {
					console.log('단어 전송 완료');
					var adjacentWords = response.words;
					var listItems = "";
					for (var i = 0; i < adjacentWords.length; i++) {
						listItems += "<li>" + adjacentWords[i] + "</li>";
					}
					$('#adjacentWordList').html(listItems);
				},
				error : function(xhr, status, error) {
					console.error('에러 발생:', error);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>한국어 텍스트에서 명사 추출하기</h2>
	<form action="${rootPath}/noun" method="GET">
		<textarea id="inputText" name="text" rows="5" cols="50"></textarea>
		<br>
		<button type="submit" id="showResultBtn">결과 보기</button>
	</form>

	<ul id="nounList">
		<!-- 명사 리스트를 순회하며 출력 -->
		<c:forEach var="noun" items="${nouns}">
			<li>${noun}</li>
		</c:forEach>
	</ul>

	<!-- 받은 인접어휘 리스트를 여기에 추가 -->
	<ul id="adjacentWordList"></ul>
</body>
</html>