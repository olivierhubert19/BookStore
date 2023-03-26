<%@page import="model.khachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://1.bp.blogspot.com/-f_5JLvF9_gU/YZGM7p_fkFI/AAAAAAAAAVo/zHkM8tD3ioAvD1pFznG1kw-QOmOibu5ywCLcBGAsYHQ/s150/1-removebg-preview.png"
				alt="Bootstrap" height="24">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Combo
							giảm giá</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Quần Jean</a></li>
							<li><a class="dropdown-item" href="#">Áo thun</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
					</li>
				</ul>
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search"
						placeholder="Nội dung tìm kiếm" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Tìm</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<script type="text/javascript">
		function Check() {
			var a = document.getElementById("matKhauMoi").value;
			var b = document.getElementById("nhapLaiMatKhauMoi").value;
			if (a == b) {
				document.getElementById("submit").style.visibility = "visible";
				document.getElementById("loiMatKhauNhapLai").innerHTML = "";
			} else {
				document.getElementById("submit").style.visibility = "hidden";
				document.getElementById("loiMatKhauNhapLai").innerHTML = "Khong giong voi mat khau moi";
			}
		}
	</script>
	<%
	khachHang khachHang = (khachHang) session.getAttribute("khachHang");
	session.setAttribute("khachHang", khachHang);
	String baoLoi = (String) request.getAttribute("baoLoi") + "";
	if (baoLoi.equals("null"))
		baoLoi = "";
	%>
	<main>
		<h1>ĐỔI MẬT KHẨU</h1>
		<div class="container col-6">
			<form action="../khach-hang" method="post">
				<input type="hidden" name="hanhDong" value="doi-mat-khau">
				<div class="text-danger"><%=baoLoi%></div>
				<div class="mb-3">
					<label for="matKhauHienTai" class="form-label">Mật khẩu
						hiện tại </label> <input type="password" class="form-control"
						id="matKhauHienTai" name="matKhauHienTai"
						aria-describedby="emailHelp">
				</div>
				<div class="mb-3">
					<label for="matKhauMoi" class="form-label">Mật khẩu mới</label> <input
						type="password" class="form-control" id="matKhauMoi"
						name="matKhauMoi">
				</div>
				<div class="mb-3">
					<label for="nhapLaiMatKhauMoi" class="form-label">Xác nhận
						mật khẩu </label> <input type="password" class="form-control"
						id="nhapLaiMatKhauMoi" onkeyup="Check()">
				</div>
				<div id="loiMatKhauNhapLai" class="text-danger"></div>
				<div class="mb-3 form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1">
					<label class="form-check-label" for="exampleCheck1">Check
						me out</label>
				</div>
				<button type="submit" class="btn btn-primary"
					style="visibility: hidden" id="submit">Xác nhận</button>
			</form>
		</div>
	</main>
</body>
</html>