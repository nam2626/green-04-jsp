<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 첫번째 페이지</h2>
	<a href="session_2.jsp">세션 두번째 페이지</a>
	<%
		session.setAttribute("user", "홍길동");
		request.setAttribute("text", "안녕하세요");
		
		//쿠키 생성 및 만료시간(초) 등록
		Cookie cookie = new Cookie("keyword","맥북");
		cookie.setMaxAge(30);
		
		response.addCookie(cookie);
	%>
</body>
</html>











