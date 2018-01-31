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
<title>물방개</title>
</head>
<body>
	<div class="container">
		<div class="masthead">
			<h3>물건파는 방구석 개인들</h3>
			<div class="text-right">
				<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
				<p>${ userInfo.nickname }(${ userInfo.id })님 안녕하세요!</p>
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
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
			
				<div id="carousel-test" class="carousel slide" data-ride="carousel" data-interval="2000">
			<ol class="carousel-indicators">
				<li data-target="#carousel-test" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-test" data-slide-to="1" class=""></li>
				<li data-target="#carousel-test" data-slide-to="2" class=""></li>
			</ol>
			
			<div class="carousel-inner">
				<div class="item active">
					<img src="http://image.gmarket.co.kr/DA/2018/01/12/20180112104835508747_4000022209_1.JPG" width="100%">
					<div class="carousel-caption">
						<h3>어서오세요 환영합니다!</h3>
						<p>우리 홈페이지는 최첨단 홈페이지로써 ... </p>
					</div>
				</div>
				<div class="item">
					<img src="http://image.gmarket.co.kr/DA/2018/01/12/20180112104835508747_4000022209_1.JPG" width="100%">
					<div class="carousel-caption">
					</div>
				</div>
				<div class="item">
					<img src="http://image.gmarket.co.kr/DA/2018/01/12/20180112104835508747_4000022209_1.JPG" width="100%">
					<div class="carousel-caption">
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-test" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#carousel-test" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>

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