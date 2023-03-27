<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>
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
<script type="text/javascript">
	function Checkmatkhau() {
		var a = document.getElementById("matKhau").value;
		var b = document.getElementById("matKhauNhapLai").value;
		if (a != b) {
			document.getElementById("loiMatKhauNhapLai").innerHTML="Mat khau nhap lai khong khop";
			document.getElementById("submit").style.visibility="hidden";
		}
		else{
			 document.getElementById("loiMatKhauNhapLai").innerHTML="";
			 KiemTraDieuKhoan();
		}
	}
	function KiemTraDieuKhoan() {
		if(document.getElementById("dongYDieuKhoan").checked) document.getElementById("submit").style.visibility="visible";
		else document.getElementById("submit").style.visibility="hidden";
		Checkmatkhau();
	}
</script>
<body>
	<% 	
		String email = (String) request.getAttribute("email")+""; 
		if(email.equals("null")) email="";	
		
		String soDienThoai = (String) request.getAttribute("soDienThoai")+"";
		if(soDienThoai.equals("null")) soDienThoai="";	
		
		String tenDangNhap = (String) request.getAttribute("tenDangNhap")+""; 
		if(tenDangNhap.equals("null")) tenDangNhap="";	
		
		String matKhau = (String) request.getAttribute("matKhau")+""; 
		if(matKhau.equals("null")) matKhau="";	
		
		String hoVaTen = (String) request.getAttribute("hoVaTen")+""; 
		if(hoVaTen.equals("null")) hoVaTen="";
		
		String ngaySinh = (String) request.getAttribute("ngaySinh"); 
		
		String diaChi = (String) request.getAttribute("diaChi")+""; 
		if(diaChi.equals("null")) diaChi="";	
		
		String gioiTinh = (String) request.getAttribute("gioiTinh")+"";
		if(gioiTinh.equals("null")) gioiTinh="";	
	
		String baoLoiString =(String) request.getAttribute("baoLoiString")+"";
		if(baoLoiString.equals("null")) baoLoiString="";
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
	%>
	<div class="text-center">
		<h1>ĐĂNG KÍ TÀI KHOẢN</h1>
	</div>
	<hr>
	<div class="col-6 container">
		<form action="<%= url %>/khach-hang" class="form" method="post">
		<input type="hidden" name="hanhDong" value="dang-ki">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin tài khoản</h3>
					<div class="mb-3 ">
						<label for="email" class="form-label">Email</label><span
							class="text-danger"> *</span> <input type="email"
							class="form-control" id="email" name="email" value=<%= email  %>>
					</div>
					<div class="mb-3 ">
						<label for="soDienThoai" class="form-label">Số
							điện thoại</label><span class="text-danger"> *</span> <input type="tel"
							class="form-control" id="soDienThoai" name="soDienThoai" required value=<%= soDienThoai %> >
					</div>
					<div class="mb-3 ">
						<label for="tenDangNhap" class="form-label">Tên đăng nhập</label><span
							class="text-danger"> *</span> <input type="text"
							class="form-control" id="tenDangNhap" name="tenDangNhap" required value=<%= tenDangNhap  %> >
					</div>
					<div class="text-danger"><%= baoLoiString %></div>
					<div class="mb-3 ">
						<label for="matKhau" class="form-label">Mật
							khẩu</label><span class="text-danger"> *</span> <input type="password"
							class="form-control" id="matKhau" name="matKhau" required value=<%= matKhau  %> >
						<div></div>
					</div>
					<div class="mb-3 ">
						<label for="matKhauNhapLai" class="form-label">Nhập lại
							mật khẩu</label><span class="text-danger"> *</span> <input
							type="password" class="form-control" id="matKhauNhapLai"
							name="matKhauNhapLai" required onkeyup="Checkmatkhau()" value=<%= matKhau  %>>
						<div id="loiMatKhauNhapLai" class="text-danger"></div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="text">
						<h3>Thông tin khách hàng</h3>
					</div>
					<div class="mb-3 ">
						<label for="hoVaTen" class="form-label">Họ
							và tên</label><span class="text-danger"> *</span> <input type="text"
							class="form-control" id="hoVaTen" name="hoVaTen" required value="<%=hoVaTen  %>" >
					</div>
					<div class="mb-3 ">
						<label for="gioiTinh" class="form-label">Giới
							tính</label> <select class="form-control" id="gioiTinh" value="<%=gioiTinh  %>"  name="gioiTinh">
							<option></option>
							<option value="Nam">Nam</option>
							<option value="Nữ">Nữ</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="ngaySinh" value="<%= ngaySinh %>" name="ngaySinh" >
					</div>
					<h3>Địa chỉ khách hàng</h3>
					<div class="mb-3 ">
						<label for="diaChi" class="form-label">Địa
							chỉ</label><span class="text-danger"> *</span> <input type="text"
							class="form-control" id="diaChi" name="diaChi" required value="<%= diaChi  %>" >
					</div>
					<hr>
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với
							điều khoản công ty </label><span class="text-danger"> *</span> <input
							type="checkbox" id="dongYDieuKhoan" name="dongYDieuKhoan"
							class="form-check-input" onclick="KiemTraDieuKhoan()"></input>
					</div>
					<div class="mb-3">
						<label for="dongYNhanMail" class="form-label">Đồng ý nhận
							email </label> <input type="checkbox" id="dongYNhanMailQuangCao"
							name="dongYNhanMailQuangCao" class="form-check-input"></input>
					</div>
					<input type="submit" value="Đăng kí"
						class="btn btn-secondary" style="visibility: hidden" id="submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>