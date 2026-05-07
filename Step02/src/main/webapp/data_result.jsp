<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request.getParameter()</h2>
	<!-- request.getParameter()의 결과는 문자열  -->
	<p>txt : <%=request.getParameter("txt") %></p>
	<p>num : <%=request.getParameter("num")%></p>
	<p>color : <%=request.getParameter("color")%></p>
	<hr>
	<h2>check box</h2>
	<!-- 동일한 name 속성값은 배열로 받음 -->
	<%
		String[] chk = request.getParameterValues("chk");
		if(chk != null){
			for(String str : chk){
				%>
				<%=str %> 
				<%
			}
		}
	%>	
</body>
</html>








