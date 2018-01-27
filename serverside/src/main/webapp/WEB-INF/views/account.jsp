<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				<a class="btn btn-primary">회원가입</a> <a class="btn btn-default">로그인</a>
				<a class="btn btn-default">마이페이지</a> <a class="btn btn-default">로그아웃</a>

			</div>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">이용안내</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</nav>
		</div>

		<hr />

		<h1>회원 가입</h1>
		<form action='<c:url value='/join'/>' method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="ID">ID</label> <input 
					class="form-control" maxlength="30" placeholder="최대 30자" name="id">
			</div>
			<div class="form-group">
				<label for="Password">Password</label> <input
					class="form-control" maxlength="30" placeholder="최대 30자" name="password">
			</div>
			<div class="radio">
				<label> <input type="radio" name="optionsRadios" id="male"
					value="male"> 남자
				</label>
			</div>
			<div class="radio">
				<label> <input type="radio" name="optionsRadios" id="female"
					value="female"> 여자
				</label>
			</div>
			<div class="form-group">
				<input type="text" name="birth" maxlength="8" placeholder="생년월일 (8자)"
					size="20">
			</div>
			<button type="submit" class="btn btn-default">회원가입</button>
		</form>
	</div>
</body>
</html>