<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 컴파일 할때 합쳐짐 -->
	<%-- <%@ include file="template/header.jsp" %>--%>
	<!-- 실행시 별도 처리 후 합쳐짐 -->
	<jsp:include page="template/header.jsp"></jsp:include>
	<hr>
	<section>
		본문 영역
	</section>
</body>
</html>