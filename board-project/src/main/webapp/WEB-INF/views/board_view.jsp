<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>
	<hr>
	<main>
		<article>
			<h3 class="board-title">제목 : ${board.title }</h3>
			<p class="board-meta-info">작성자 : ${board.nickName },
				작성일 : ${board.writeDate }(${board.updateDate })</p>
			<p class="board-meta-info">조회수 : ${board.bcount}</p>
			<div class="board-content">
				${board.content }
			</div>
			<div class="board-actions">
				<button class="btn btn-like" type="button">
					<img src="./resources/img/like_icon.png">
					<span>${board.blike }</span>
				</button>
				<button class="btn btn-hate" type="button">
					<img src="./resources/img/like_icon.png">
					<span>${board.bhate }</span>
				</button>
			</div>
			<div class="board-actions">
				<a href="javascript:history.back();" class="btn btn-back">뒤로가기</a>
				<c:if test="${session.user.no == board.mno }">
					<a href="./boardDelete.do?bno=${board.bno }" class="btn btn-delete">삭제</a>
					<a href="./boardUpdateView.do?bno=${board.bno }" class="btn btn-update">수정</a>
				</c:if>
			</div>
			<div class="board-file-list">
				<c:forEach var="file" items="${flist }">
					<p><a href="./fileDown.do?fno=${file.fno }">${file.fileName }</a></p>
				</c:forEach>
			</div>
		</article>
	</main>

</body>
</html>
