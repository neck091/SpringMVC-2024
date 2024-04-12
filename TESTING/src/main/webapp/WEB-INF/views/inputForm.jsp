<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!-- inputForm.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>한글 텍스트 형태소 분석</title>
</head>
<body>
    <h2>한글 텍스트 형태소 분석</h2>
    <form action="${rootPath}/analyzeText" method="post">
        <textarea name="text" rows="5" cols="50"></textarea><br>
        <input type="submit" value="분석 시작">
    </form>
</body>
</html>