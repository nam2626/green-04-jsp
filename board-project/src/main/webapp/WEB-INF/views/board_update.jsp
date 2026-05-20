<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.snow.css" rel="stylesheet" />
<script src="https://cdn.jsdelivr.net/npm/quill@2.0.3/dist/quill.js"></script>
<script>
	// Quill 에디터의 상단 툴바(기능 버튼들) 설정입니다.
	const toolbarOptions = [
		  ['bold', 'italic', 'underline', 'strike'],        // 굵게, 기울임, 밑줄, 취소선
		  ['blockquote', 'code-block'],                     // 인용구, 코드 블록
		  ['link', 'image', 'video', 'formula'],            // 링크, 이미지, 영상, 수식
	
		  [{ 'header': 1 }, { 'header': 2 }],               // 제목 1, 제목 2
		  [{ 'list': 'ordered'}, { 'list': 'bullet' }, { 'list': 'check' }], // 목록 종류
		  [{ 'script': 'sub'}, { 'script': 'super' }],      // 아래첨자, 위첨자
		  [{ 'indent': '-1'}, { 'indent': '+1' }],          // 내어쓰기, 들여쓰기
		  [{ 'direction': 'rtl' }],                         // 글자 방향(오른쪽에서 왼쪽)
	
		  [{ 'size': ['small', false, 'large', 'huge'] }],  // 글자 크기
		  [{ 'header': [1, 2, 3, 4, 5, 6, false] }],        // 제목 크기 선택
	
		  [{ 'color': [] }, { 'background': [] }],          // 글자색, 배경색
		  [{ 'font': [] }],                                 // 글꼴 선택
		  [{ 'align': [] }],                                // 정렬
	
		  ['clean']                                         // 모든 서식 지우기
		];

	window.onload = () => {
		// 1. 에디터를 'editor'라는 id를 가진 div에 생성합니다.
		const quill = new Quill('#editor', {
			modules: {
			    toolbar: toolbarOptions
			  },
		    theme: 'snow'
		  });
		
		// 2. 폼이 전송(submit)될 때 실행될 함수입니다.
		document.querySelector("form").onsubmit = (e) => {
			// 에디터에 입력된 내용을 HTML 형식으로 가져와서, 
			// 눈에 보이지 않는 hidden input 태그(#content)에 넣어줍니다.
			// 서버(자바)에서는 이 hidden input의 값을 읽어서 DB에 저장합니다.
			document.querySelector("#content").value = quill.getSemanticHTML();  
		}
	}
</script>
<style>
	/* 에디터의 높이를 500픽셀로 고정합니다. */
	#editor {
	  height: 500px;
	}
</style>
</head>
<body>
	<!-- 상단 메뉴바 포함 -->
	<jsp:include page="./template/header.jsp"></jsp:include>
	<hr>
	<div class="write-card">
		<h1>게시글 수정</h1>
		<!-- 실제 정보 수정을 처리하는 boardUpdate.do로 데이터를 보냅니다. -->
		<form action="./boardUpdate.do" method="post">
			<!-- 수정할 글의 번호를 보이지 않게 전달합니다. -->
			<input type="hidden" name="bno" value="${board.bno }">
			
			<div class="write-title-group">
				<label for="writeTitle">제목</label>
				<input type="text" id="writeTitle" name="title" value="${board.title }"  placeholder="제목을 입력해주세요">
			</div>
			
			<!-- 에디터 영역: 기존 글의 내용(${board.content})을 미리 채워둡니다. -->
			<div id="editor">${board.content }</div>
			
			<!-- 에디터의 HTML 내용을 담아서 서버로 보낼 숨겨진 필드입니다. -->
			<input type="hidden" name="content" id="content">
			
			<div class="write-actions">
				<button>수정하기</button>
				<button type="button" onclick="history.back();">뒤로가기</button>
			</div>
		</form>
	</div>
</body>
</html>








