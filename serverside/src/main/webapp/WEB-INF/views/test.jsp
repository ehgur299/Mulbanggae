<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<a class="btn btn-default">로그인</a> <a class="btn btn-default">마이페이지</a>
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

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-9">
				
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in (USER)</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" class="form-control" placeholder="ID address" required="" autofocus="">
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
			<button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 10px">Sign in</button>
		</form>
		
		<hr/>
		
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
				<!-- /.col-lg-4 -->
			</div>
			<!--/row-->
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