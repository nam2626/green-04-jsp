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
	<!-- 영역(scope) 쓰지 않으면 자동 검색
		page -> request -> session -> application
	 -->
	<p> msg : ${msg }</p>	
	<h2>jstl(JSP Standard Tag Library)</h2>
	<!-- set : 변수 선언해서 초기화 -->
	<c:set var="num" value="1000"></c:set>
	<c:set var="obj" value="${sessionScope.user }" scope="request"  />
	<p>${num }, ${requestScope.obj }</p>
	<!-- out : 출력 -->
	<p><c:out value="${num }" default="숫자 없음"/></p>
	<p><c:out value="${num1 }" default="숫자 없음"/></p>
	<!-- if -->
	<c:if test="${age >= 20}">
		<p>성인입니다.</p>
	</c:if>	
	<c:if test="${age < 20}">
		<p>미성년자 입니다.</p>
	</c:if>	
	<!-- choose, when otherwise -->
	<c:choose>
		<c:when test="${age >= 20 && age < 30 }">
			<p>20대 입니다.</p>
		</c:when>
		<c:when test="${age >= 30 && age < 40 }">
			<p>30대 입니다.</p>
		</c:when>
		<c:otherwise>
			<p>40대 이상입니다</p>
		</c:otherwise>	
	
	</c:choose>
	<!-- 반복문 -->
</body>
</html>




















