<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 - 회원정보 수정</title>
<script>
	/**
	 * [입력 값 검증 함수]
	 * 수정 폼의 모든 입력 칸이 채워졌는지 확인합니다.
	 */
	async function checkField(){
		let result = true;
	
		// 모든 input 태그를 찾아 빈 칸이 있는지 검사합니다.
		let input = document.querySelectorAll("input");
		input.forEach(item => {	
			if(item.value.trim() == '')
				result = false;
		});
		return result;
	}

	window.onload = () => {
		/**
		 * [수정 폼 제출(Submit) 이벤트]
		 * 수정 버튼을 눌렀을 때 실행됩니다.
		 */
		document.querySelector('form').onsubmit = async (e) => {
			// 1. 브라우저의 기본 제출 기능(페이지 이동)을 잠시 막습니다.
			e.preventDefault();
			
			// 2. 입력 값이 모두 채워졌는지 확인합니다.
			let result = await checkField();
			
			if(result) {
				// 3. 검증이 통과되면 실제로 데이터를 서버(update.do)로 보냅니다.
				e.target.submit();
			} else {
				// 4. 비어있는 칸이 있으면 경고창을 띄웁니다.
				alert('모든 항목을 입력해 주세요.');
			}
		}
		
		/**
		 * [취소 버튼 클릭 이벤트]
		 */
		document.querySelector("#btnCancel").onclick = () => {
			// 이전 페이지(메인 목록 등)로 돌아갑니다.
			history.back();
		}
	}
</script>
</head>
<body>
	<h2>회원정보수정</h2>
	<!-- 
		action="./update.do": 수정한 데이터를 처리할 서버 주소
		method="post": 비밀번호 등 민감한 정보를 안전하게 보내기 위해 POST 방식을 사용합니다.
	-->
	<form action="./update.do" method="post">
		<!-- 
			회원 번호(no)는 화면에 보여줄 필요는 없지만, 
			서버에서 누구의 정보를 바꿀지 알아야 하므로 hidden 타입으로 몰래 보냅니다.
		-->
		<input type="hidden" name="no" value="${dto.no }"> 
		
		<!-- 아이디는 수정할 수 없도록 readonly 속성을 부여합니다. -->
		아이디 : <input type="text" id="id" readonly value="${dto.id }"><br>
		
		<!-- 기존 정보를 value="${dto...}"를 이용해 미리 채워넣습니다. -->
		암호 : <input type="text" name="passwd" placeholder="새 암호를 입력해주세요"><br>
		이름 : <input type="text" name="name" placeholder="이름을 입력해주세요" value="${dto.userName }"><br>
		닉네임 : <input type="text" name="nick" placeholder="닉네임 입력해주세요" value="${dto.nickName }"><br>
		
		<button>수정 완료</button>
		<button type="button" id="btnCancel">취소</button>
	</form>
</body>
</html>
