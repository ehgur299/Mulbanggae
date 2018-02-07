<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
				<p>${ item.nickname }(${ item.id })님 안녕하세요!</p>
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
					<li class="active"><a href="#">Home</a></li>
					<li><a href="<c:url value='/product/product.do'/>">상품게시판</a></li>
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>

		<hr />

		<h1>공지사항 작성</h1>
		<form action="<c:url value='/notice/notice-modify.do'/>" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
			<c:if test="${ param.action == 'error-password' }">
				<p>비밀번호가 일치하지 않습니다.</p>
			</c:if>
				<tr>
					<td>작성자</td>
					<td>${ item.nickname }(${ item.id })</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="noticeTitle"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="5" cols="60" name="content"
							id="noticeContent"></textarea></td>
				</tr>
				<tr>
					<td>이미지</td>
					<td><input type="file" name="url" id="noticePhoto" multiple="multiple"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="no" value="${ item.no }">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<button type="submit" class="btn btn-default">등록</button>
						<a href="<c:url value='/notice/notice.do'/>" type="button" class="btn btn-default">공지사항 목록으로 이동</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>