<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 결과</title>
</head>
<body>
<%
	// POST 방식 수신 데이터의 한글 깨짐 방지
	request.setCharacterEncoding("UTF-8");
%>
	<h2>회원 가입 결과</h2>
	<p>아이디 : <%=request.getParameter("userId") %></p>
	<p>이름 : <%=request.getParameter("userName") %></p>
	
	<p>선택한 취미: <br>
		<%
			// 여러 개의 값을 가질 수 있는 체크박스는 getParameterValues()를 사용합니다.
			String[] hobbys = request.getParameterValues("hobby");
			if(hobbys != null){
				for(String str : hobbys){
			%>
				[<%= str %>] 
			<%
				}
			} else {
				out.print("선택한 취미가 없습니다.");
			}
		%>
	</p>
</body>
</html>