<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 이동 처리</title>
</head>
<body>
	<%
		// 폼에서 넘어온 파라미터를 읽습니다.
		String type = request.getParameter("type");
		String text = request.getParameter("txt");
		
		// request 영역에 데이터를 임시로 저장합니다.
		request.setAttribute("txt", text);
		
		/* 
		   이동 방식 선택:
		   1. Forward: 서버 내에서 직접 이동. request 데이터가 유지됨. 브라우저 주소창이 바뀌지 않음.
		   2. Redirect: 브라우저에게 새로운 주소로 다시 요청하라고 명령. request 데이터가 유실됨. 주소창이 바뀜.
		*/
		if(type != null && type.equals("forward")) {
			// forward.jsp로 이동 (request, response 객체를 전달)
			request.getRequestDispatcher("forward.jsp").forward(request, response);
		} else {
			// redirect.jsp로 이동 (완전히 새로운 요청을 생성하게 함)
			response.sendRedirect("redirect.jsp");
		}
	%>
</body>
</html>