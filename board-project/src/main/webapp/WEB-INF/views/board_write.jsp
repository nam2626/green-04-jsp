<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>
	<hr>
	<h1>글쓰기 페이지</h1>
	<form action="./boardWrite.do" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		내용<br>
		<div id="editor"></div>
		<input type="hidden" name="content" id="content">
		<hr>
		<input type="file" name="file"><br>
		<input type="file" name="file"><br>
		<input type="file" name="file"><br>
		<button>글쓰기</button>
		<button type="button" onclick="history.back();">뒤로가기</button>
	</form>
</body>
</html>








