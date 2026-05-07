<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 및 쿠키 설정</title>
</head>
<body>
	<h2>세션 첫번째 페이지</h2>
	<p><a href="session_2.jsp">세션 두번째 페이지로 이동</a></p>
	
	<%
		// session 객체에 데이터를 저장합니다. 브라우저가 닫히기 전까지 유지됩니다.
		session.setAttribute("user", "홍길동");
		
		// request 객체에 데이터를 저장합니다. 이 요청이 끝나면 사라집니다.
		request.setAttribute("text", "안녕하세요 (Request 범위)");
		
		/* 
		   쿠키(Cookie) 생성: 클라이언트(브라우저) 측에 저장되는 데이터입니다.
		   - 이름: "keyword", 값: "맥북"
		*/
		Cookie cookie = new Cookie("keyword", "맥북");
		
		// 쿠키의 유효 기간을 설정합니다. (초 단위)
		// 2147483647초는 약 68년으로, 영구 쿠키에 가깝게 설정한 예시입니다.
		cookie.setMaxAge(2147483647);
		
		// 응답 헤더에 쿠키를 추가하여 브라우저로 보냅니다.
		response.addCookie(cookie);
	%>
</body>
</html>