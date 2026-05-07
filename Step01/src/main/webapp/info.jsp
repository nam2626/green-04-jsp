<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
	<h2>서버 정보 페이지</h2>
	<p>현재 시간 : <%=sdf.format(new Date()) %></p>
	<p>요청 URL : <%=request.getRequestURL() %></p>
	<p>브라우저 정보 : <%=request.getHeader("User-Agent") %>
	
</body>
</html>







