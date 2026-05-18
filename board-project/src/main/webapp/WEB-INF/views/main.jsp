<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<hr>
	<!-- 게시판 글목록
			글번호, 제목[댓글 개수], 작성일, 닉네임, 조회수, 좋아요, 싫어요
	-->
	<table class="board_table">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>닉네임</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
		</thead>
		<tbody class="board_content_list">
			<c:forEach var="board" items="${requestScope.list }">
				<tr>
					<td>${board.bno }</td>
					<td>${board.title }[${board.ccount }]</td>
					<td>${board.writeDate }</td>
					<td>${board.nickName }</td>
					<td>${board.bcount }</td>
					<td>${board.blike }</td>
					<td>${board.bhate }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
				<!-- 페이징 처리부분 -->
				페이징 처리 영역
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>






















