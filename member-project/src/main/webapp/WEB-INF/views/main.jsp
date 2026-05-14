<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width:800px;
		margin : 0 auto;
		table-layout: fixed;
		border-collapse: collapse;
	}
	td,th{
	border :1px solid black;
	
	}
	.passwd {
		width: 400px;
		text-overflow: ellipsis;
		overflow: hidden;
		white-space: nowrap;
	}
	

</style>
</head>
<body>
	<nav>
		<c:if test="${sessionScope.member == null }">
			<a href="./loginView.do">로그인</a>
			<a href="./registerView.do">회원 가입</a>
		</c:if>
		<c:if test="${sessionScope.member != null }">
			<a href="./loginOut.do">로그아웃</a>
			<span>${sessionScope.member.nickName }님이 로그인하셨습니다.</span>
		</c:if>
	</nav>
	<hr>
	<!-- 전체 회원정보 -->
	<table>
		<thead>
			<tr>
				<th>no</th>
				<th>id</th>
				<th>passwd</th>
				<th>userName</th>
				<th>nickName</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${list }" var="member">
				<tr>
					<td>${member.no }</td>
					<td>${member.id }</td>
					<td class="passwd">${member.passwd }</td>
					<td>${member.userName }</td>
					<td>${member.nickName }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>










