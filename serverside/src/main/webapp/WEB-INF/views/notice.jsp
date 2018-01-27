<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<title>물방개</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3>물건파는 방구석 개인들</h3>
			<div class="text-right">
				<a class="btn btn-default">로그인</a> 
				<a class="btn btn-default">마이페이지</a>
				<a class="btn btn-default">로그아웃</a>
			</div>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">이용안내</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<h1>공지사항</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ notice }" var="item">
				<tr>
					<td><a href="<c:url value='/notice/notice-detail.do?no=${ item.no }'/>">${ item.no }</a></td>
					<td>${ item.title }</td>
					<td>${ item.userInfo.nickname }</td>
					<td>${ item.date }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<hr />
		<a class="btn btn-default">글쓰기</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</body>
</html>