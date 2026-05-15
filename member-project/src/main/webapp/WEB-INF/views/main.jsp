<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- [JSTL 핵심 라이브러리 추가] c:if, c:forEach 등을 사용하기 위해 선언합니다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 - 메인</title>
<style type="text/css">
	table{
		width:800px;
		margin : 0 auto;
		table-layout: fixed;
		border-collapse: collapse;
	}
	td,th{
		border :1px solid black;
	}
	/* 비밀번호 열이 너무 길어지지 않게 처리하는 스타일 */
	.passwd {
		width: 400px;
		text-overflow: ellipsis; /* 넘치는 텍스트를 ...으로 표시 */
		overflow: hidden;
		white-space: nowrap;
	}
</style>
<script>
	/**
	 * [삭제 버튼 이벤트 등록 함수]
	 * 화면에 그려진 삭제 버튼들에 클릭 이벤트를 연결합니다.
	 */
	function addDeleteEvent(){
		// class가 btnDelete인 모든 요소를 찾아 반복문을 돌립니다.
		document.querySelectorAll('.btnDelete').forEach((item) => {
			item.addEventListener('click',() => {
				// 1. 클릭한 버튼의 할아버지(tr)의 첫 번째 자식(td)에서 회원 번호를 가져옵니다.
				let no = item.parentElement.parentElement.firstElementChild.innerText;
				
				// 2. 사용자에게 한 번 더 확인을 받습니다.
				if(confirm(no + '번 회원을 정말 삭제할까요?')){
					// 3. 확인을 누르면 삭제 요청 URL로 이동합니다.
					location.href="./delete.do?no="+no;
				}
			});
		});
	}

	// 문서의 모든 요소가 로드된 후 실행될 코드
	window.onload = () => {
		// 처음 로드될 때 삭제 버튼 이벤트 등록
		addDeleteEvent();

		/**
		 * [검색 버튼 클릭 이벤트 - AJAX 방식]
		 * 페이지 새로고침 없이 서버와 통신하여 검색 결과를 가져옵니다.
		 */
		document.querySelector('#btnSearch').onclick = async (e) => {
			let btn = e.target;
			let tags = btn.closest('td'); // 클릭한 버튼이 포함된 <td> 태그를 찾습니다.

			// 서버로 보낼 데이터를 담을 객체 생성 (kind=id&search=abc 형태)
			const param = new URLSearchParams();
			// td 내부의 input과 select 태그의 값을 수집합니다.
			tags.querySelectorAll('input,select').forEach(item => {
				param.append(item.id, item.value);
			});
			
			// 요청할 URL 조립 (ES6 템플릿 리터럴 사용)
			// JSP 파일 안에서 JS의 \${}를 쓰려면 앞에 \를 붙여야 JSP가 자신의 변수로 오해하지 않습니다.
			let url = `./search.do?\${param.toString()}`;
			console.log("요청 URL:", url);
			
			// 1. fetch를 이용해 서버에 비동기(Async) 요청을 보냅니다.
			let response = await fetch(url);
			// 2. 서버가 응답한 데이터를 JSON 형식으로 변환합니다.
			let data = await response.json();
			
			console.log("서버로부터 받은 데이터:", data);
			
			// 3. 검색 결과를 화면에 그릴 영역을 선택합니다.
			const area = document.querySelector("#list_area");
			area.innerHTML = ''; // 기존 목록을 지웁니다.
			
			// 4. 받아온 list 데이터를 반복하며 HTML 태그를 조립합니다.
			let tag = '';
			data.list.forEach(item => {
				// 백틱(`)을 사용하면 여러 줄의 문자열을 편리하게 만들 수 있습니다.
				tag += '<tr>';
				tag += `<td>\${item.no}</td>`;
				tag += `<td>\${item.id}</td>`;
				tag += `<td class="passwd">\${item.passwd}</td>`;
				tag += `<td>\${item.userName}</td>`;
				tag += `<td>\${item.nickName}</td>`;
				tag += `<td>
							<button class="btnDelete">삭제</button>
							<a class="btnUpdate" href="./updateView.do?no=\${item.no}">수정</a>
						</td>`;
				tag += '</tr>';
			})
			
			// 5. 조립된 태그를 화면에 넣습니다.
			area.innerHTML = tag;
			
			// 6. 새로 생긴 삭제 버튼들에 이벤트를 다시 등록해줍니다.
			addDeleteEvent();
		}
	}
</script>
</head>
<body>
	<nav>
		<%-- [로그인 여부에 따른 메뉴 표시] sessionScope를 통해 로그인 상태를 확인합니다. --%>
		<c:if test="${sessionScope.member == null }">
			<a href="./loginView.do">로그인</a>
			<a href="./registerView.do">회원 가입</a>
		</c:if>
		<c:if test="${sessionScope.member != null }">
			<a href="./loginOut.do">로그아웃</a>
			<span><strong>${sessionScope.member.nickName }</strong>님이 로그인하셨습니다.</span>
		</c:if>
	</nav>
	<hr>
	
	<table>
		<thead>
			<!-- [검색 영역] -->
			<tr>
				<td colspan="6">
					<select id="kind">
						<option value="id">아이디</option>
						<option value="username">이름</option>
						<option value="nickname">닉네임</option>
					</select>					
					<input type="text" id="search" placeholder="검색어를 입력하세요">
					<button id="btnSearch">검색</button>
				</td>
			</tr>
			<!-- [테이블 제목] -->
			<tr>
				<th>no</th>
				<th>id</th>
				<th>passwd (암호화됨)</th>
				<th>userName</th>
				<th>nickName</th>
				<th>비고</th>
			</tr>		
		</thead>
		<tbody id="list_area">
			<%-- [전체 회원 목록 출력] c:forEach를 이용해 서버에서 보낸 list 데이터를 반복합니다. --%>
			<c:forEach items="${list }" var="member">
				<tr>
					<td>${member.no }</td>
					<td>${member.id }</td>
					<td class="passwd">${member.passwd }</td>
					<td>${member.userName }</td>
					<td>${member.nickName }</td>
					<td>
						<button class="btnDelete">삭제</button>
						<a class="btnUpdate" href="./updateView.do?no=${member.no }">수정</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
