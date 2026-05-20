<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style>
	button.btn-comment-like *,
	button.btn-comment-hate *{
		pointer-events: none;
	}

</style>
<script>
	window.onload = (e) => {
		const bno = '${board.bno}';
		
		// --- 게시글 좋아요 버튼 클릭 이벤트 ---
		document.querySelector('.btn-like').onclick = async (e) => {
			// 1. 비동기(AJAX) 방식으로 서버의 boardLike.do를 호출합니다.
			// fetch를 사용하면 페이지 새로고침 없이 데이터만 주고받을 수 있습니다.
			const response = await fetch(`./boardLike.do?bno=\${bno}`);
			
			// 2. 서버가 보낸 응답(JSON)을 자바스크립트 객체로 변환합니다.
			const data = await response.json();

			// 3. 처리 결과를 알림창으로 보여줍니다.
			alert(data.msg);
			
			// 4. 만약 로그인하지 않은 상태라면(resultCode 1), 로그인 페이지로 이동시킵니다.
			if(data.resultCode == 1)
				location.href="./loginView.do";

			// 5. 화면에 표시된 좋아요 개수를 서버에서 받아온 최신 값(data.count)으로 바꿉니다.
			document.querySelector('.btn-like span').innerHTML = data.count;
		}

		// --- 게시글 싫어요 버튼 클릭 이벤트 ---
		document.querySelector('.btn-hate').onclick = async (e) => {
			// 1. 싫어요 처리를 위한 URL을 만들고 서버에 요청합니다.
			const url = `./boardHate.do?bno=\${bno}`;
			const response = await fetch(url);
			const data = await response.json();
			
			// 2. 결과를 출력합니다.
			alert(data.msg);
			
			// 3. 비로그인 시 로그인 화면으로 이동
			if(data.resultCode == 1)
				location.href = "./loginView.do";

			// 4. 싫어요 개수를 최신화합니다.
			document.querySelector('.btn-hate span').innerHTML = data.count;
		}

		// --- 댓글별 좋아요/싫어요 버튼 클릭 이벤트 등록 ---
		// 모든 댓글의 좋아요/싫어요 버튼을 찾아서 클릭 이벤트를 하나씩 연결합니다.
		document.querySelectorAll("button.btn-comment-like,button.btn-comment-hate").forEach(item => {
			item.onclick = async (e) => {
				// 클릭된 버튼이 속한 댓글 아이템에서 댓글 번호(cno)를 가져옵니다.
				const cno = e.target.closest(".comment-item").querySelector("input[name='cno']").value;
				
				// '좋아요'인지 '싫어요'인지 구분하여 요청 URL을 만듭니다.
				let url = `./boardCommentLikeHate.do?cno=\${cno}&mode=`
				if(e.target.className.indexOf('like') != -1){
					url += "like";					
				}else{
					url += "hate";					
				}
				
				// 서버에 비동기 요청을 보냅니다.
				const response = await fetch(url);
				const data = await response.json();
				
				// 처리 결과 메시지를 보여주고, 해당 버튼의 숫자(count)를 갱신합니다.
				alert(data.msg);
				e.target.querySelector('span').innerHTML = data.count;
			}
		})
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
				<c:if test="${sessionScope.user.no == board.mno }">
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
		<hr>
		<section class="comment-area">
			<!-- 댓글 폼 
					1. 로그인 했을 때만 댓글 입력 폼을 작성
						- 댓글, 글번호
					2. 로그인 안했을 때는 '댓글을 입력하실려면 로그인 하세요' 
			-->
			<c:choose>
				<c:when test="${user != null}">
					<form action="./boardCommentInsert.do" method="post" class="comment-form">
						<textarea name="content" required></textarea>
						<button>댓글달기</button>
						<input type="hidden" name="bno" value="${board.bno}">
					</form>
				</c:when>
				<c:otherwise>
					<p class="comment-non-login">댓글을 입력하실려면 로그인 하세요</p>
				</c:otherwise>
			</c:choose>

			<!-- 댓글 목록 -->
			<div class="comment-list">
				<c:forEach var="comment" items="${clist }">
					<div class="comment-item">
						<input type="hidden" name="cno" value="${comment.cno }">
						<p class="comment-info">
							작성자 : ${comment.nickName }, 작성일 : ${comment.cdate }
						</p>
						<p class="comment-content">${comment.content }</p>
						<p class="comment-actions">
							<button type="button" class="btn btn-comment-like">
								<img src="./resources/img/like_icon.png">
								<span>${comment.clike }</span>
							</button>
							<button type="button" class="btn btn-comment-hate">
								<img src="./resources/img/like_icon.png">
								<span>${comment.chate }</span>
							</button>
							<c:if test="${session.user.no == comment.mno }">
								<a href="./commentDelete.do" class="btn btn-comment-delete">삭제</a>
							</c:if>
						</p>
					</div>
				</c:forEach>
			</div>
			<!-- 댓글 더보기 버튼 -->
			<button type="button" class="btn btn-comment-more">댓글 더보기</button>
		</section>
	</main>

</body>
</html>





