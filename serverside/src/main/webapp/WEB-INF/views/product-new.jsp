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
<script type="text/javascript">
	function getSelectValue(frm){
 		frm.m_ctg.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
		}
	function check_onclick(){
		theForm=document.frm;
		if(theForm.title.value=="" || theForm.productname.value=="" || theForm.price.value=="" || thForm.content==""){
			alert("필수 입력란이 비었습니다. 확인해 주세요.");
			}
		}
</script>
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
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>

		<hr />

		<h1>상품 등록</h1>
		<form name="frm" action="<c:url value='/product/product-new.do'/>" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>작성자</td>
					<td>${ item.nickname }(${ item.id })</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" id="productTitle"></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="name" id="productName"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="number" name="price" id="productPrice"></td>
				</tr>
				<tr>
					<td>상품설명</td>
					<td><textarea rows="5" cols="60" name="content"
							id="productContent"></textarea></td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td><input type="file" name="url" id="productPhoto" multiple="multiple"></td>
				</tr>
				<tr>
					<td>카테고리</td>
					<td>
					<select name="selectBox" onChange="getSelectValue(this.form);">
					<option value="1">의류</option>
 					<option value="2">스포츠/레저</option>
 					<option value="3">디지털/가전</option>
 					<option value="4">도서/취미/애완/티켓</option>
 					<option value="5">차량/오토바이</option>
 					<option value="6">생활/문구/가구/식품</option>
 					<option value="7">유아동/출산</option>
 					<option value="8">기타</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="hidden" name="no" value="${ item.no }">
						<input type="hidden" value="1" name="cid">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<button type="submit" class="btn btn-default">등록</button>
						<a href="<c:url value='/product/product.do'/>" type="check" class="btn btn-default" onclick="check_onclick()">상품 목록으로 이동</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>