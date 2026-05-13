<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="./register.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력해주세요">
		<button type="button" id="btnCheck">중복확인</button><br>
		<div id="idCheckResult"></div>
		<input type="text" name="passwd" placeholder="암호를 입력해주세요"><br>
		<input type="text" name="name" placeholder="이름을 입력해주세요"><br>
		<input type="text" name="nick" placeholder="닉네임 입력해주세요"><br>
		<button>가입하기</button>
		<button type="button" id="btnCancel">취소</button>
	</form>
</body>
</html>



