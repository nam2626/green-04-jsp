<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문 연습</title>
</head>
<body>
	<h2>조건문 (if-else)</h2>
	<%
		// 자바 문법과 동일하게 조건문을 사용할 수 있습니다.
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
		// HTML 태그와 자바 코드를 혼용하여 반복적으로 HTML을 생성할 수 있습니다.
		for(int i=1;i<=5;i++){
	%>
			<li>리스트 항목 <%=i %></li>					
	<%
		}
	%>
	</ul>
	
	<h2>반복문 - while</h2>
	<%-- 1~100까지의 합계를 구하는 예제 --%>
	<%
		int i = 1;
		int sum = 0;
		while(i <= 100){
			sum += i++;
		}
	%>
	<p>1부터 100까지의 합 : <%=sum %></p>
</body>
</html>