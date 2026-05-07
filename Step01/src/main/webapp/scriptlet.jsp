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
	
	<%-- 
		1. 선언부(Declaration): <%! %> 
		변수(필드)나 메서드를 선언할 때 사용합니다. 
		여기서 선언된 변수는 서블릿 클래스의 멤버 변수가 됩니다.
	--%>
	<%!
		String msg = "안녕하세요";
		
		public int add(int a, int b){
			return a+b;
		}
	%>
	
	<%-- 
		2. 스크립트릿(Scriptlet): <% %> 
		자바 코드를 직접 실행할 때 사용합니다. 
		여기서 선언된 변수는 _jspService() 메서드 내부의 지역 변수가 됩니다.
	--%>
	<%
		String name = "홍길동";
		int result = add(10, 20);
	%>
	
	<%-- 
		3. 표현식(Expression): <%= %> 
		자바 코드의 값이나 실행 결과를 브라우저 화면에 출력할 때 사용합니다.
		세미콜론(;)을 붙이지 않습니다.
	--%>
	<p> 인사말 : <%= msg %></p>
	<p> 이름 : <%=name %></p>
	<p> 10 + 20 : <%=result %></p>
</body>
</html>