<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 여러 페이지에서 공통으로 사용할 상단 메뉴 바 템플릿입니다. --%>
<ul class="menu_bar">
	<li><a href="">메뉴1</a></li>
	<li><a href="">메뉴2</a></li>
	<li><a href="">메뉴3</a></li>
	<li><a href="">메뉴4</a></li>
	<li><a href="">메뉴5</a></li>
	<li><a href="">메뉴6</a></li>
</ul>

<style>
	.menu_bar {
		width: 1200px;
		display: flex;
		flex-flow: row nowrap;
		gap : 10px;
		margin: 0 auto;
		list-style: none;
		padding: 0;
	}
	.menu_bar a:link, .menu_bar a:visited {
		display: inline-block;
		width: 150px;
		padding: 20px 0px;
		text-align: center;
		color: black;
		text-decoration: none;
		border : 1px solid #ccc;
	}
	.menu_bar a:hover {
		background-color: #f0f0f0;
	}
</style>