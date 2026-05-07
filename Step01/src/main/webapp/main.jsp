<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<%-- 
		파일을 포함하는 두 가지 방법:
		
		1. 정적 포함 (include 지시어): <%@ include file="..." %>
		   - 컴파일 시점에 해당 파일의 소스 코드가 현재 페이지에 합쳐집니다.
		   - 주로 변하지 않는 레이아웃(헤더, 푸터)에 사용합니다.
	--%>
	<%-- <%@ include file="template/header.jsp" %> --%>
	
	<%-- 
		2. 동적 포함 (include 액션 태그): <jsp:include page="..." />
		   - 실행(런타임) 시점에 해당 페이지를 호출하여 그 결과를 현재 페이지에 포함합니다.
		   - 별도의 서블릿으로 처리되므로 독립적인 작업이 가능합니다.
	--%>
	<jsp:include page="template/header.jsp"></jsp:include>
	
	<hr>
	<section style="text-align: center; padding: 50px;">
		<h2>본문 영역입니다.</h2>
		<p>헤더가 성공적으로 포함되었습니다.</p>
	</section>
</body>
</html>