<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 예제</title>
</head>
<body>
	<h2>JSP 스크립트릿 3가지</h2>
	<%-- 1. 선언부(<%! %>) : 필드, 메서드 선언 방법 --%>
	<%!
		String msg = "안녕하세요";
		
		public int add(int a, int b){
			return a+b;
		}
	%>
	
	<%-- 2. 스크립트릿(<% %>) : 자바 코드 실행 부분  --%>
	<%
		String name = "홍길동";
		int result = add(10, 20);
	%>
	
	<%-- 3. 표현식(<%= 값%>) : 값 출력 부분  --%>
	<p> 인사말 : <%= msg %></p>
	<p> 이름 : <%=name %></p>
	<p> 10 + 20 : <%=result %></p>
</body>
</html>











