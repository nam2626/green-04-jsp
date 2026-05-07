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
		String type = request.getParameter("type");
		String text = request.getParameter("txt");
		
		//request 영역에 text 저장
		request.setAttribute("txt", text);
		
		//type에 따라서 이동하는 방법을 다르게 처리
		request.getRequestDispatcher("forward.jsp").forward(request, response);
	%>
	
	
</body>
</html>











