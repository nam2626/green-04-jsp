<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect 결과</title>
</head>
<body>
	<h2>Redirect 방식으로 이동한 페이지</h2>
	<%-- 
		Redirect 방식은 브라우저가 새로운 요청을 보내는 것이기 때문에, 
		이전 페이지에서 request.setAttribute()로 담은 데이터는 유실되어 null이 나옵니다.
	--%>
	<p>전달받은 text 값: <%=request.getAttribute("txt") %> (데이터 유실 확인)</p>
	<p style="color:red;">※ Redirect는 새로운 요청이므로 request 객체의 데이터가 유지되지 않습니다.</p>
</body>
</html>