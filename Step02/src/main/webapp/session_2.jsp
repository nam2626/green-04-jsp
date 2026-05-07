<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>세션 테스트 페이지</h2>
	<p> text : <%=request.getAttribute("text") %> </p>
	<p> user: <%=session.getAttribute("user") %> </p>
	<%
		//쿠키 읽어오는 부분
		Cookie[] cookies = request.getCookies();
		for(int i = 0;i<cookies.length;i++){
			%>
				<p><%=cookies[i].getName() %> / <%=cookies[i].getValue() %></p>
			<%
		}
	
	%>
</body>
</html>





