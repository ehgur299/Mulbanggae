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
<style>
.star-input>.input, .star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	display: inline-block;
	vertical-align: middle;
	background: url('../img/grade_img.png') no-repeat;
}

.star-input {
	display: inline-block;
	white-space: nowrap;
	width: 225px;
	height: 40px;
	padding: 25px;
	line-height: 30px;
}

.star-input>.input {
	display: inline-block;
	width: 150px;
	background-size: 150px;
	height: 28px;
	white-space: nowrap;
	overflow: hidden;
	position: relative;
}

.star-input>.input>input {
	position: absolute;
	width: 1px;
	height: 1px;
	opacity: 0;
}

star-input>.input.focus {
	outline: 1px dotted #ddd;
}

.star-input>.input>label {
	width: 30px;
	height: 0;
	padding: 28px 0 0 0;
	overflow: hidden;
	float: left;
	cursor: pointer;
	position: absolute;
	top: 0;
	left: 0;
}

.star-input>.input>label:hover, .star-input>.input>input:focus+label,
	.star-input>.input>input:checked+label {
	background-size: 150px;
	background-position: 0 bottom;
}

.star-input>.input>label:hover ~label {
	background-image: none;
}

.star-input>.input>label[for="p1"] {
	width: 30px;
	z-index: 5;
}

.star-input>.input>label[for="p2"] {
	width: 60px;
	z-index: 4;
}

.star-input>.input>label[for="p3"] {
	width: 90px;
	z-index: 3;
}

.star-input>.input>label[for="p4"] {
	width: 120px;
	z-index: 2;
}

.star-input>.input>label[for="p5"] {
	width: 150px;
	z-index: 1;
}

.star-input>output {
	display: inline-block;
	width: 60px;
	font-size: 18px;
	text-align: right;
	vertical-align: middle;
}
</style>
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
					<li><a href="#">이용안내</a></li>
					<li><a href="<c:url value='notice'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				<h1>${ item.nickname }(${ item.id })</h1>
				<a href="<c:url value='/user/modify'/>" class="btn btn-default">회원 수정</a>
				<a href="<c:url value='/user/delete'/>" class="btn btn-default">회원 탈퇴</a>
				
				<hr />
				
				<div class="row">
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis
							euismod. Nullam id dolor id nibh ultricies vehicula ut id elit.
							Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
							Praesent commodo cursus magna.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Duis mollis, est non commodo luctus, nisi erat porttitor
							ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
							purus sit amet fermentum. Fusce dapibus, tellus ac cursus
							commodo, tortor mauris condimentum nibh.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
							alt="Generic placeholder image" width="140" height="140">
						<h2>Heading</h2>
						<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
							in, egestas eget quam. Vestibulum id ligula porta felis euismod
							semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
							condimentum nibh, ut fermentum massa justo sit amet risus.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details »</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
				</div>
				<!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->

			<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
					<a class="list-group-item active" href="<c:url value='/product/product.do'/>">전체 상품 보기</a>
				</div>


			</div>
			<!--/.sidebar-offcanvas-->
		</div>
	</div>

	<script src="../js/jquery-1.11.3.min.js"></script>
	<script src="../js/star.js"></script>
	<script src="../js/jquery-1.12.4.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>