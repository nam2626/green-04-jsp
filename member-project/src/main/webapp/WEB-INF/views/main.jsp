<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	.passwd {
		width: 400px;
		text-overflow: ellipsis;
		overflow: hidden;
		white-space: nowrap;
	}
	

</style>
<script>
	window.onload = () => {
		//btnDelete 클릭했을 때 삭제할 회원번호를 no로 저장한 후에
		//let no = ?
		//location.href="./delete.do?no="+no
		document.querySelectorAll('.btnDelete').forEach((item) => {
			item.addEventListener('click',() => {
				let no = item.parentElement.parentElement.firstElementChild.innerText;
				console.log(no);
				location.href="./delete.do?no="+no
			});
		});
		// 검색 버튼 이벤트 처리
		document.querySelector('#btnSearch').onclick = async (e) => {
			// let kind = document.querySelector("#kind").value;
			// let search = document.querySelector("#search").value;

			// let url = `./search.do?kind=\${kind}&search=\${search}`;
			// console.log(url);
			let btn = e.target;
			let tags = btn.closest('td'); //클릭한 버튼의 부모태그 선택
			console.log(tags.querySelectorAll('input,select'));
			console.log(tags.children);

			const param = new URLSearchParams();
			tags.querySelectorAll('input,select').forEach(item => {
				param.append(item.id,item.value);
			});
			let url = `./search.do?\${param.toString()}`;
			console.log(url);
			
			let response = await fetch(url);
			let data = await response.json();
			
			console.log(data);
		}
	}

</script>
</head>
<body>
	<nav>
		<c:if test="${sessionScope.member == null }">
			<a href="./loginView.do">로그인</a>
			<a href="./registerView.do">회원 가입</a>
		</c:if>
		<c:if test="${sessionScope.member != null }">
			<a href="./loginOut.do">로그아웃</a>
			<span>${sessionScope.member.nickName }님이 로그인하셨습니다.</span>
		</c:if>
	</nav>
	<hr>
	<!-- 전체 회원정보 -->
	<table>
		<thead>
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
			<tr>
				<th>no</th>
				<th>id</th>
				<th>passwd</th>
				<th>userName</th>
				<th>nickName</th>
				<th>비고</th>
			</tr>		
			
		</thead>
		<tbody id="list_area">
			<c:forEach items="${list }" var="member">
				<tr>
					<td>${member.no }</td>
					<td>${member.id }</td>
					<td class="passwd">${member.passwd }</td>
					<td>${member.userName }</td>
					<td>${member.nickName }</td>
					<td><button class="btnDelete">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>










