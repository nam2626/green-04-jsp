<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 수신 결과 (GET)</title>
</head>
<body>
	<h2>request.getParameter()를 이용한 데이터 읽기</h2>
	
	<%-- 
		request.getParameter("name"): 
		HTML 폼(form)의 input 태그 등에서 지정한 name 속성값을 이용해 전달된 데이터를 가져옵니다. 
		결과는 항상 문자열(String) 타입입니다.
	--%>
	<p>전달받은 텍스트(txt): <%=request.getParameter("txt") %></p>
	<p>전달받은 숫자(num): <%=request.getParameter("num")%></p>
	<p>선택한 색상(color): <%=request.getParameter("color")%></p>
	
	<hr>
	
	<h2>체크박스 데이터 처리 (다중 값)</h2>
	<%-- 
		request.getParameterValues("name"):
		체크박스와 같이 동일한 name으로 여러 값이 전달될 때 배열 형태로 가져옵니다.
	--%>
	<%
		String[] chk = request.getParameterValues("chk");
		if(chk != null){
			out.println("<p>선택한 항목들:</p><ul>");
			for(String str : chk){
				%>
				<li><%=str %></li>
				<%
			}
			out.println("</ul>");
		} else {
			out.println("<p>선택한 항목이 없습니다.</p>");
		}
	%>	
</body>
</html>