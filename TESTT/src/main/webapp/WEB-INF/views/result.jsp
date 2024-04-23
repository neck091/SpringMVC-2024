<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<div>

   <h1>Adjacent Words List</h1>
    <ul id="adjacentWordList">
        <!-- 받은 단어 리스트를 반복하여 출력 -->
        <c:forEach var="word" items="${words}">
            <li>${word}</li>
        </c:forEach>
    </ul>
</div>