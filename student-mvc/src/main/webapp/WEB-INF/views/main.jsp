<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL의 Core 태그를 사용하기 위해 선언합니다. (반복문, 조건문 등을 JSP에서 쓰기 위해) --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리 시스템 - 목록</title>
</head>
<body>
	<%-- 상단 메뉴 --%>
	<a href="./insertView.do">학생정보 추가</a>
	<a href="./updateView.do">학생정보 수정</a>
	<hr>
	<h2>학생 목록</h2>
	<main>
		<section>
			<table>
				<thead>
					<%-- 검색창 --%>
					<tr>
						<td colspan="5">
							<form action="./search.do" method="get">
								<input type="text" name="name" placeholder="이름 일부 입력">
								<button>검색</button>
							</form>
						</td>
					</tr>
					<%-- 표 제목 --%>
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>학과명</th>
						<th>평점</th>
						<th>작업</th>
					</tr>
				</thead>
				<tbody>
				<%-- 
					JSTL의 forEach를 이용해 서버에서 전달받은 학생 리스트(list)를 하나씩 꺼내서 출력합니다. 
					${requestScope.list}는 컨트롤러가 'list'라는 이름으로 담아둔 데이터를 의미합니다.
				--%>
				<c:forEach var="dto" items="${requestScope.list }">
					<tr>
						<td>${dto.no }</td>
						<td>${dto.name }</td>
						<td>${dto.majorName }</td>
						<td>${dto.score }</td>
						<td>
							<%-- 특정 학생을 삭제하거나 수정하기 위해 학번(no)을 주소에 실어서 보냅니다. --%>
							<a href="./delete.do?no=${dto.no }">삭제</a> 
							/
							<a href="./updateView.do?no=${dto.no }">수정</a> 
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</section>
	</main>		
</body>
</html>







