<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<h1>상품목록</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>상품번호</th>
					<th>상품사진</th>
					<th>제목</th>
					<th>상품명</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>132</td>
					<td>안녕하세요.</td>
					<td>홍길동</td>
					<td>2017.01.21</td>
				</tr>
			</tbody>
		</table>

		<hr />
		<a class="btn btn-default">상품 등록</a>

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