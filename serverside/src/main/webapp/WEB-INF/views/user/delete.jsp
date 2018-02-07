<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<h1>정말로 탈퇴하시겠습니까?</h1>
	<form action='<c:url value='/user/delete'/>' method="post">
		<label>비밀번호 <input type="password" name="password"></label>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value='탈퇴하기'>
	</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-theme.min.css">
<title>물방개</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3>물건파는 방구석 개인들</h3>
			<div class="text-right">
				<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
					<p>${ item.nickname }(${ item.id })님안녕하세요!</p>
				</sec:authorize>
				<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
					<a href="<c:url value='/join'/>" class="btn btn-primary">회원가입</a>
					<a href="<c:url value='/login'/>" class="btn btn-default">로그인</a>
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
					<a href="<c:url value='/user/mypage'/>" class="btn btn-default">마이페이지</a>
					<a href="<c:url value='/logout'/>" class="btn btn-default">로그아웃</a>
				</sec:authorize>
			</div>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="<c:url value='/'/>">Home</a></li>
					<li><a href="<c:url value='/product/product.do'/>">상품게시판</a></li>
					<li><a href="<c:url value='notice'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				<h1>정말로 탈퇴하시겠습니까?</h1>
					<form action='<c:url value='/user/delete'/>' method="post">
						<table class="table table-bordered">
						<tr>
						<td>비밀번호</td>
						</tr> 
						<tr>
						<td><input type="password" name="password"></td>
						</tr>
						<tr>
						<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></td>
						<td><input type="submit" value='탈퇴하기'></td>
						</table>
					</form>
			</div>
		</div>
	</div>
	<script src="../js/jquery-1.11.3.min.js"></script>
	<script src="../js/star.js"></script>
	<script src="../js/jquery-1.12.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>