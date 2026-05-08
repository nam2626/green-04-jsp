<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		height: 5000px;
	}
</style>
</head>
<body>
	<h2>EL(Expression Language) </h2>
	<p>jsp에서 데이터를 쉽고 간결하게 접근하기 위해 사용하는 스크립트 언어</p>
	<p>request 영역에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age }</p>
	<p>msg : ${requestScope.msg } </p>
	<p>세션에 저장된 내용은 sessionScope를 사용해서 뽑음</p>
	<!-- user에 저장된 필드도 하나씩 뽑기 -->
	<ul>
		<li>${sessionScope.user.id }</li>
		<li>${sessionScope.user.name }</li>
		<li>${sessionScope.user.passwd }</li>
		<li>${sessionScope.user.nick }</li>
		<li>${sessionScope.user.toString() }</li>
	</ul>
</body>
</html>









