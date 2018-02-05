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
<title>접근 불가 페이지</title>
</head>
<body>
	<div class="container">
		<h3>물건파는 방구석 개인들</h3>
		<div class="text-center">
			<h1>접근 불가 페이지</h1>
			<div>
				<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
					<span>${ id }</span>
					<span>님 은 접근 불가한 페이지입니다.</span>
					<br>
					<a href="<c:url value = '/'/>" class="btn btn-default">홈으로</a>
					<a href="<c:url value = '/logout'/>" class="btn btn-default">로그아웃</a>
				</sec:authorize>
				<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
					<span>해당 페이지 접근 가능한 아이디로 로그인 하세요.</span>
					<br>
					<a href="<c:url value = '/'/>" class="btn btn-default">홈으로</a>
					<a href="<c:url value = '/login'/>" class="btn btn-default">로그인</a>
				</sec:authorize>
			</div>
		</div>
	</div>
</body>
</html>