<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/login.css">
<title>물방개</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btnLogin").click(function(){
			var adminId = $("adminId").val();
			var adminPwd = $("adminPwd").val();
			if(adminId == ""){
				alert("아이디를 입력하세요.");
				$("#adminId").focus();
				return;
			}
			if(adminPwd == ""){
				alert("비밀번호를 입력하세요.");
				$("#adminPwd").focus();
				return;
			}

			document.form1.action="${path}/admin/loginCheck.do"

			document.form1.submit();
			})
		})
</script>
</head>
<body>
	<div class="container">
	
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in (ADMIN)</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input name="adminId" id="adminId" class="form-control" placeholder="ID address" required="" autofocus="">
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" name="adminPwd" id="adminPwd" class="form-control" placeholder="Password" required="">
			<button class="btn btn-lg btn-primary btn-block" type="submit" style="margin-top: 10px">Sign in</button>
		</form>

	</div>

</body>
</html>