<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
header {
	padding: 1.3rem;
	text-align: center;
	display: flex;
	justify-content: center;
}

h1 {
	text-align: center;
}

nav {
	background-color: black;
	color: yellow;
}

ul {
	list-style-type: none;
	display: flex;
	gap: 5px;
}

li {
	padding: 12px 16px;
}
</style>
<!DOCTYPE html>
<html>
<tiles:insertAttribute name="head" />
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="nav" />
	<tiles:insertAttribute name="content" />




</body>
</html>
