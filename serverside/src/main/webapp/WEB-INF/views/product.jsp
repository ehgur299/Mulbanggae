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
<link rel="stylesheet" href="../css/ctg.css">
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
					<li class="active"><a href="<c:url value='/'/>">Home</a></li>
					<li><a href="<c:url value='/product/product.do'/>">상품게시판</a></li>
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				
				<h1>상품목록</h1>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>상품번호</th>
							<th>제목</th>
							<th>상품명</th>
							<th>가격</th>
							<th>작성자</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ product }" var="product">
						<tr>
							<td>${ product.no }</td>
							<td><a href="<c:url value='/product/product-detail.do?no=${ product.no }'/>">${ product.title }</a></td>
							<th>${ product.name }</th>
							<th>${ product.price }
							<td>${ product.userInfo.nickname }</td>
							<td>${ product.date }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

				<hr />
				<sec:authorize access="hasRole('ADMIN') or hasRole('USER')" >
				<a href="<c:url value='/product/product-new.do'/>" class="btn btn-default">상품 등록</a>
				</sec:authorize>

				<div class="text-center">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</ul>
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!--/row-->
			<!--/.col-xs-12.col-sm-9-->

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<a class="list-group-item active" href="<c:url value='/product/product.do'/>">전체 상품 보기</a>
				</div>
			</div>
			<!--/.sidebar-offcanvas-->
		</div>
	</div>
</body>
</html>