<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<script>
	window.onload = (e) => {
		// 좋아요 버튼을 클릭 경고창 출력
		// 경고창 출력시 글번호도 출력
		const bno = '${board.bno}';
		document.querySelector('.btn-like').onclick = async (e) => {
			// alert(`좋아요 버튼 클릭 : \${bno}`);
			// boardLike.do 호출해서 좋아요 처리 -> board_like 추가
			// 전달할 데이터 : 글번호
			// 받는 데이터 : 결과메세지 msg
			// 					'이 게시글에 좋아요를 하셨습니다.'
			//					'이 게시글에 좋아요를 취소하셨습니다.'
			//			    좋아요 개수 count
			// 데이터를 응답 받으면 좋아요 개수를 최신화, 결과 메세지는 경고창으로 출력
			const response = await fetch(`./boardLike.do?bno=\${bno}`);
			const data = await response.json();

			
			alert(data.msg);
			//로그인 안했을 떄 경고창 확인 후 로그인 페이지로 이동
			if(data.resultCode == 1)
				location.href="./loginView.do";

			document.querySelector('.btn-like span').innerHTML = data.count;
		}
	}

</script>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>
	<hr>
	<main>
		<article>
			<h3 class="board-title">제목 : ${board.title }</h3>
			<p class="board-meta-info">글번호 : <span id="bno">${board.bno}</span></p>
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
