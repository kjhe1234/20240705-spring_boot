<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<form action="joinOk">
		아이디 : <input type="text" name="mid" size="60"><br><br>
		비밀번호 : <input type="password" name="mpw" size="60"><br><br>
		이름 : <input type="text" name="mname" size="60"><br><br>
		이메일 : <input type="text" name="memail" size="60"><br><br>
		<input type="submit" value="가입신청">		
	</form>		
	<hr>
	<h2>${joinFail }</h2>
</body>
</html>