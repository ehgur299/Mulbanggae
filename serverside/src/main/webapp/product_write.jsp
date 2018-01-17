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
				<a class="btn btn-default">로그인</a> 
				<a class="btn btn-default">마이페이지</a>
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

		<hr />

		<h1>상품 등록</h1>
		<form id="form1" name="form1" enctype="multipart/form-data"
			method="post">
			<table class="table table-bordered">
				<tr>
					<td>제목</td>
					<td><input type="text" name="productTitle" id="productTitle"></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="productName" id="productName"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="productPrice" id="productPrice"></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><textarea rows="5" cols="60" name="productDesc"
							id="productDesc"></textarea></td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td><input type="file" name="productPhoto" id="productPhoto"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="등록"
						id="addBtn"> <input type="button" value="목록" id="listBtn">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>