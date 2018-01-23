<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form>
			<div class="form-group">
				<label for="ID">ID</label> <input 
					class="form-control" maxlength="30" placeholder="최대 30자">
			</div>
			<div class="form-group">
				<label for="Password">Password</label> <input
					class="form-control" maxlength="30" placeholder="최대 30자">
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
				<input type="text" name="birthyy" maxlength="4" placeholder="년(4자)"
					size="6"> <select name="birthmm">
					<option value="">월</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select> <input type="text" name="birthdd" maxlength="2" placeholder="일"
					size="4">
			</div>
			<button type="submit" class="btn btn-default">회원가입</button>
		</form>
	</div>
</body>
</html>