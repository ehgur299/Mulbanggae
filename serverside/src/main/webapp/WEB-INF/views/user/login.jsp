<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/login.css">
<title>물방개</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3>물건파는 방구석 개인들</h3>
			<div class="text-right">
				<a class="btn btn-primary">회원가입</a>
				<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER')">
				<a href="<c:url value='/login'/>" class="btn btn-default">로그인</a> 
				</sec:authorize>
				<sec:authorize access="hasRole('ADMIN') and hasRole('USER')">
				<a class="btn btn-default">마이페이지</a>
				<a class="btn btn-default">로그아웃</a>
				</sec:authorize>
			</div>
			<nav>
				<ul class="nav nav-justified">
					<li class="active"><a href="<c:url value='/'/>">Home</a></li>
					<li><a href="#">이용안내</a></li>
					<li><a href="#">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">

				<form action="<c:url value="/login-processing"/>" method="post" class="form-signin">
					<c:if test="${ param.action == 'error' }">
						<p>아이디 혹은 비밀번호를 잘못 입력하였습니다.</p>
					</c:if>
					
					<h2 class="form-signin-heading">Please sign in</h2>
					
					<label for="ID" class="sr-only">ID address</label> 
					<input type="text" id="ID" name="id" class="form-control" 
					placeholder="ID address" required="" autofocus=""> 
					<label for="Password" class="sr-only">Password</label> 
					<input type="password" id="Password" name="pwd" class="form-control"
					placeholder="Password" required="">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						style="margin-top: 10px">sign in</button>
				</form>
				
			</div>
			<!--/.col-xs-12.col-sm-9-->

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<a href="#" class="list-group-item active">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a> <a href="#"
						class="list-group-item">Link</a>
				</div>


			</div>
			<!--/.sidebar-offcanvas-->
		</div>
	</div>

	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>