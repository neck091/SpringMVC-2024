<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>문장 입력 및 명사 추출</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#inputText').on('input', function() {
			var text = $(this).val();
			// AJAX를 통해 서버에 요청을 전송
			$.ajax({
				type : 'POST',
				url : '/extractNouns',
				data : JSON.stringify({
					text : text
				}),
				contentType : 'application/json',
				success : function(data) {
					// 서버에서 받은 명사를 화면에 표시
					$('#nounList').empty();
					$.each(data.nouns, function(index, noun) {
						$('#nounList').append('<li>' + noun + '</li>');
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>한국어 텍스트에서 명사 추출하기</h2>
	<form method="POST">
		<textarea id="inputText" rows="5" cols="50"></textarea>
		<br>
		<ul id="nounList"></ul>
	</form>
</body>
</html>