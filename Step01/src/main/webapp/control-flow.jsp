<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>조건문</h2>
	<%
		int score = 75;
		String grade = "F";
		if(score >= 90)
			grade = "A";
		else if(score >= 80)
			grade = "B";
		else if(score >= 70)
			grade = "C";
		else if(score >= 60)
			grade = "D";		
	%>
	<p>점수 : <%=score %>, 학점 : <%=grade %></p>
	
	<h2>반복문 - for</h2>
	<ul>
	<%
		for(int i=1;i<=5;i++){
	%>
			<li><%=i %></li>					
	<%
		}
	%>
	</ul>
	
	<h2>반복문 - while</h2>
	<!-- 1~100까지 합 출력 -->
	<%
		
	%>
</body>
</html>










