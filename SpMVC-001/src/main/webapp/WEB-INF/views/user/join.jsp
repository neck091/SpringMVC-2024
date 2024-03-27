<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입을해</title>
</head>
<body>
	<h1>회원가입</h1>

	<form method="post">
	<div><input placeholder="ID" name="username"></input></div>
	<div><input placeholder="Password"  name="password"></input></div>
	<div><input placeholder="이름"  name="name"></input></div>
	<div><input placeholder="이메일"  name="email"></input></div>
	<div><input placeholder="전화번호"  name="tel"></input></div>
	<div><input type="submit" value="회원가입"></input></div>
	</form>
	
	<p>${USER.username}</p>
	<p>${USER.password}</p>
	<p>${USER.name}</p>
	<p>${USER.email}</p>
	<p>${USER.tel}</p>

</body>
</html>