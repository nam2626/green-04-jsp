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
		/* 한글깨짐 방지 */
		request.setCharacterEncoding("UTF-8");
	
	%>
	<p> 이름 : <%=request.getParameter("name") %></p>
	<p> 나이 : <%=request.getParameter("age") %></p>
	<hr>
	<p>메서드 정보 : <%=request.getMethod() %></p>	
	<p>URI : <%=request.getRequestURI() %></p>	
	<p>URL : <%=request.getRequestURL() %></p>	
	<p>아이피 주소 : <%=request.getRemoteAddr() %></p>	
	<p>언어 : <%=request.getHeader("Accept-Language") %></p>	
	<p>콘텍스트 루트(프로젝트 경로) : <%=request.getContextPath() %></p>	
</body>
</html>






