<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>맞춤법 검사</title>
</head>
<body>
    <h1>맞춤법 검사기</h1>
    <form action="${pageContext.request.contextPath}/correct" method="post">
        <textarea name="text" rows="10" cols="50" placeholder="맞춤법을 검사할 텍스트를 입력하세요"></textarea><br>
        <button type="submit">검사하기</button>
    </form>
    
    <h2>검사 결과</h2>
    <p>${correctedText}</p>
</body>
</html>