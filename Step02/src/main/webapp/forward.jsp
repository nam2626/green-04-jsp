<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward 결과</title>
</head>
<body>
	<h2>Forward 방식으로 이동한 페이지</h2>
	<%-- 
		Forward 방식은 서버 내부에서 페이지를 전환하기 때문에, 
		이전 페이지에서 request 객체에 담은 데이터를 그대로 가져올 수 있습니다.
	--%>
	<p>전달받은 text 값: <%=request.getAttribute("txt") %></p>
</body>
</html>