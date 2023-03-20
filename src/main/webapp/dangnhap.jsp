<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Dang nhap</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
String baoLoi = request.getAttribute("baoLoi")+"";
if(baoLoi.equals("null")) baoLoi="";
%>
<!-- Custom styles for this template -->
<link href="<%=url%>/css/sign-in.css" rel="stylesheet">
</head>
<body>
	<main class="form-signin w-100 m-auto">
		<form class="text-center" action="xuLyDangNhap" method="post">
			<img class="mb-4" src="<%=url%>/img/logo/book.png" alt=""
				width="90">
			<h1 class="h3 mb-3 fw-normal">Đăng nhập</h1>
			<div class="text-center text-danger"><%= baoLoi %></div>
			<div class="form-floating">
				<input type="text" class="form-control" id="tenDangNhap"
					placeholder="Tên đăng nhập" name="tenDangNhap"> <label for="tenDangNhap">Tên
					đăng nhập</label>
			</div>

			<div class="form-floating">
				<input type="password" class="form-control" id="Password"
					placeholder="Password" name="Password"> <label for="Password">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>

			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<hr>
			<a href="register.jsp" class="btn btn-outline-success"
				style="white-space: nowrap;">Đăng kí tài khoản mới</a>
			<p class="mt-5 mb-3 text-muted">&copy; OliverHubert 2023</p>
		</form>
	</main>
</body>
</html>