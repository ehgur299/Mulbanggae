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
					<li><a href="<c:url value='/product/product.do'/>">상품게시판</a></li>
					<li><a href="<c:url value='/notice/notice.do'/>">공지사항</a></li>
				</ul>
			</nav>
		</div>
		<hr>

		<h1>공지사항</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호: ${ item.no }</th>
					<th>제목: ${ item.title }</th>
					<th>작성자: ${ item.userInfo.nickname }</th>
					<th>날짜: ${ item.date }</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
			<div>
			<c:if test="${ !empty filename }">
				<img src="<c:url value='/notice/${ filename }'/>" width="540" height="400">
			</c:if>
				<p>${ item.content }</p>
			</div>
		
		<hr />
		
		<div class="text-right">
		<c:if test="${ !empty filename }">
			<p>첨부파일</p>
			<a href="<c:url value='/notice/download.do?filename=${ item.url }'/>">${ filename }</a>
		</c:if>
		</div>
		
		<hr />
		
		<textarea id="commentParentText" class="form-control col-lg-12" style="width: 100%" rows="4"></textarea>
						</span></td>
					</tr>
				</table>
				<table class="table table-condensed">
					<thead>
						<tr>
							<td><span style='float: right'>
									<button type="button" id="write" class="btn btn-default">확인</button>
							</span></td>
						</tr>
					</thead>
				</table>
				
		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</body>
</html>