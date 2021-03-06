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
					<p>${ userInfo.nickname }(${ userInfo.id })님안녕하세요!</p>
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
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">

				<h1>게시글 삭제</h1>
				<form action="<c:url value='/product/product-remove.do'/>"
					method="post">
					<c:if test="${ param.action == 'error-password' }">
						<p>비밀번호를 잘못 입력했습니다.</p>
					</c:if>
					<table>
						<tr>
							<td><input type="hidden" name="no" value="${ no }">
							</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td><input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}"> <input type="submit"
								value="삭제하기"></td>
						</tr>
					</table>
				</form>
				<a href="<c:url value='/product/product.do'/>">게시판 목록으로 이동</a>


				<hr />
				<!--/row-->
				<!--/.col-xs-12.col-sm-9-->

				<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
					<div class="list-group">
						<a class="list-group-item active"
							href="<c:url value='/product/product.do'/>">전체 상품 보기</a>
					</div>
				</div>
				<!--/.sidebar-offcanvas-->
			</div>
		</div>
	</div>
</body>
</html>