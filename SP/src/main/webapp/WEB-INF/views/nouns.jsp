<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Noun Extraction Result</title>
</head>
<body>
    <h1>Noun Extraction Result</h1>
    <p>Extracted Nouns:</p>
    <ul>
    <% for (String noun : nouns) { %>
        <li><%= noun %></li>
    <% } %>
    </ul>
    <a href="${pageContext.request.contextPath}">Back to Input</a>
</body>
</html>