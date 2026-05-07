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
	request.setCharacterEncoding("UTF-8");
%>
	<h2>회원 가입 결과</h2>
	<p>아이디 : <%=request.getParameter("userId") %></p>
	<p>이름 : <%=request.getParameter("userName") %></p>
	<p>취미 <br>
		<%
			String[] hobbys = request.getParameterValues("hobby");
			if(hobbys != null){
				for(String str : hobbys){
			%>
				<%= str %>
			<%
				}
			}
				
		
		%>
	</p>
</body>
</html>








