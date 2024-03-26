<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
		<div><input placeholder="USERNAME" name="username"></input></div>
		<div><input placeholder="비밀번호" name="password"></input></div>
		<div><input placeholder="비밀번호확인" name="re_password"></input></div>
		<div><input placeholder="이름" name="name"></input></div>
		<div><input placeholder="이메일" name="email"></input></div>
		<div><input placeholder="전화번호" name="tel"></input></div>
		<div><input type="submit" value="회원가입"></input></div>
	</form>
	
	<p>${USER.username}</p>
	<p>${USER.password}</p>
	<p>${USER.name}</p>
	<p>${USER.email}</p>
	<p>${USER.tel}</p>

</body>
</html>