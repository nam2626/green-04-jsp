<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 - 로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<!-- 
		로그인 정보를 입력받아 ./login.do 경로로 전송하는 폼입니다. 
		비밀번호가 포함되므로 post 방식을 사용합니다.
	-->
	<form action="./login.do" method="post">
		<input type="text" name="id" placeholder="아이디를 입력해주세요"><br>
		<input type="text" name="passwd" placeholder="암호를 입력해주세요"><br>
		<button>로그인</button>
		
		<!-- 회원가입 버튼 클릭 시 가입 페이지(registerView.do)로 이동합니다. -->
		<button type="button" id="btnRegister" onclick="location.href='./registerView.do'">회원가입</button>
	</form>
</body>
</html>
