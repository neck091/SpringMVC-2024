<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맞춤법 검사기</title>
</head>
<body>
    <h1>맞춤법 검사기</h1>
    <form action="/hello/correct" method="post">
        <textarea name="textInput" rows="5" cols="50"></textarea><br>
        <input type="submit" value="검사하기"><br><br>
    </form>
   <div id="result">
    ${correctedText}
</div>
</body>
</html>