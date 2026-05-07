<%-- 외부 자바 클래스를 사용하기 위해 import 합니다. --%>
<%@page import="java.util.Date"%>
<%-- JSP 페이지의 설정 정보(언어, 콘텐츠 타입, 인코딩)를 정의합니다. --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello, JSP!</h1>
	<%-- <%= %>는 표현식(Expression)으로, 자바 코드의 실행 결과를 브라우저에 출력합니다. --%>
	<p>현재시간 : <%=new Date().toLocaleString() %></p>
</body>
</html>