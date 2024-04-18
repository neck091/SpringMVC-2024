<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<div>
	<h1>Extracted Nouns</h1>
    <ul>
        <!-- 명사 리스트를 순회하며 출력 -->
        <c:forEach var="noun" items="${nouns}">
            <li>${noun}</li>
        </c:forEach>
    </ul>
</div>