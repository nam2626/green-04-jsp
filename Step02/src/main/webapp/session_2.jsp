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
</body>
</html>