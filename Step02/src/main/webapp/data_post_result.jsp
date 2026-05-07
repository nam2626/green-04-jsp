<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 수신 결과 (POST)</title>
</head>
<body>
	<%
		/* 
		   POST 방식으로 데이터를 보낼 때는 한글이 깨질 수 있으므로, 
		   데이터를 읽기 전에 반드시 문자 인코딩을 설정해주어야 합니다.
		*/
		request.setCharacterEncoding("UTF-8");
	%>
	
	<h3>수신된 사용자 정보</h3>
	<p> 이름 : <%=request.getParameter("name") %></p>
	<p> 나이 : <%=request.getParameter("age") %></p>
	
	<hr>
	
	<h3>요청 관련 부가 정보</h3>
	<%-- 클라이언트와 서버 간의 다양한 정보를 request 객체 메서드로 확인할 수 있습니다. --%>
	<p>전송 방식(Method) : <%=request.getMethod() %></p>	
	<p>요청 URI : <%=request.getRequestURI() %></p>	
	<p>서버 IP 주소 : <%=request.getRemoteAddr() %></p>	
	<p>브라우저 수용 언어 : <%=request.getHeader("Accept-Language") %></p>	
	<p>컨텍스트 경로(프로젝트 루트) : <%=request.getContextPath() %></p>	
</body>
</html>