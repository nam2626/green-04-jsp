<%-- 날짜 처리를 위해 필요한 자바 클래스들을 가져옵니다. --%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서버 정보</title>
</head>
<body>
<%
	// 날짜 형식을 지정하는 객체를 생성합니다.
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
%>
	<h2>서버 및 요청 정보 확인</h2>
	<p>현재 시간 : <%=sdf.format(new Date()) %></p>
	
	<%-- request 객체는 클라이언트의 요청 정보를 담고 있는 기본 객체입니다. --%>
	<p>요청 URL : <%=request.getRequestURL() %></p>
	<p>브라우저(User-Agent) 정보 : <%=request.getHeader("User-Agent") %></p>
	
</body>
</html>