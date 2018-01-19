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
<script type="text/javascript">
	function chkword(obj, maxByte) {

		var strValue = obj.value;
		var strLen = strValue.length;
		var totalByte = 0;
		var len = 0;
		var oneChar = "";
		var str2 = "";

		for (var i = 0; i < strLen; i++) {
			oneChar = strValue.charAt(i);
			if (escape(oneChar).length > 4) {
				totalByte += 2;
			} else {
				totalByte++;
			}

			// 입력한 문자 길이보다 넘치면 잘라내기 위해 저장
			if (totalByte <= maxByte) {
				len = i + 1;
			}
		}

		// 넘어가는 글자는 자른다.
		if (totalByte > maxByte) {
			alert(maxByte + "자를 초과 입력 할 수 없습니다.");
			str2 = strValue.substr(0, len);
			obj.value = str2;
			chkword(obj, 4000);
		}
	}
</script>
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
				<label for="userId">ID</label> <input class="form-control"
					id="userId" placeholder="최대 30자" onkeyup="chkword(this, 30)">
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input
					class="form-control" id="userPassword" placeholder="최대 30자"
					onkeyup="chkword(this, 30)">
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
				<label for="userPassword">생년월일</label> <input type="number"
					name="quantity" min="1900" max="2019">년 <input
					type="number" name="quantity" min="1" max="13">월 <input
					type="number" name="quantity" min="1" max="32">일
			</div>
			<button type="submit" class="btn btn-default">제출</button>
		</form>
	</div>
</body>
</html>