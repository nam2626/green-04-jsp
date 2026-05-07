<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 및 쿠키 확인</title>
</head>
<body>
	<h2>세션 데이터 확인 페이지</h2>
	
	<%-- 
		request.getAttribute()는 이전 페이지에서 forward 되었을 때만 값이 존재합니다.
		05_session.jsp에서 링크를 타고(Redirect와 유사한 새로운 요청) 왔으므로 여기서는 null입니다.
	--%>
	<p> request 영역 데이터 : <%=request.getAttribute("text") %> (null 예상)</p>
	
	<%-- 
		session.getAttribute()는 같은 브라우저 세션 내내 유지됩니다.
		따라서 05_session.jsp에서 저장한 "홍길동" 값이 잘 나옵니다.
	--%>
	<p> session 영역 데이터(user): <%=session.getAttribute("user") %> </p>
	
	<hr>
	
	<h3>저장된 쿠키 목록 확인</h3>
	<%
		// 브라우저가 보내온 쿠키들을 배열로 읽어옵니다.
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++){
				%>
				<p>쿠키 이름: <strong><%=cookies[i].getName() %></strong> / 쿠키 값: <%=cookies[i].getValue() %></p>
				<%
			}
		} else {
			out.print("저장된 쿠키가 없습니다.");
		}
	%>
</body>
</html>