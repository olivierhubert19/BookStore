<%@page import="model.khachHang"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin</title>
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
	s
</script>
<body>
	
	<% khachHang khachHang = (khachHang) session.getAttribute("khachHang");
		if(khachHang==null){
			%>
			<h1>Ban chua dang nhap vui long dang nhap de thuc hien chuc nang nay!</h1>
		<% }
		else{
			%>
	<% 	
		String email = khachHang.getEmail()+""; 
		if(email.equals("null")) email="";	
		
		String soDienThoai = khachHang.getSoDienThoai()+"";
		if(soDienThoai.equals("null")) soDienThoai="";	
		
		String tenDangNhap = khachHang.getTenDangNhap()+""; 
		if(tenDangNhap.equals("null")) tenDangNhap="";	
		
		String hoVaTen = khachHang.getHoVaTen()+""; 
		if(hoVaTen.equals("null")) hoVaTen="";
		
		String ngaySinh = khachHang.getNgaySinh().toString(); 
		
		String diaChi = khachHang.getDiachi()+""; 
		if(diaChi.equals("null")) diaChi="";	
		
		String gioiTinh = khachHang.getGioiTinh()+"";
		if(gioiTinh.equals("null")) gioiTinh="";	
	
		String baoLoiString =(String) request.getAttribute("baoLoiString")+"";
		if(baoLoiString.equals("null")) baoLoiString="";
		
		session.setAttribute("khachHang", khachHang);
	%>
	<div class="text-center">
		<h1>THAY ĐỔI THÔNG TIN</h1>
	</div>
	<hr>
	<div class="col-6 container">
		<form action="../khach-hang" class="form" method="post">
		<input type="hidden" name="hanhDong" value="thay-doi-thong-tin">
			<div class="row">
				<div class="col-md-6">
					<h3>Thông tin tài khoản</h3>
					<div class="mb-3 ">
						<label for="email" class="form-label">Email</label><span
							class="text-danger"> *</span> <input type="email"
							class="form-control" id="email" name="email" value=<%= email %>>
					</div>
					<div class="mb-3 ">
						<label for="soDienThoai" class="form-label">Số
							điện thoại</label><span class="text-danger"> *</span> <input type="tel"
							class="form-control" id="soDienThoai" name="soDienThoai" required value=<%= soDienThoai %> >
					</div>
					<div class="text-danger"><%= baoLoiString %></div>
					</div>
				<div class="col-md-6">
					<div class="text">
						<h3>Thông tin khách hàng</h3>
					</div>
					<div class=" ">
						<label for="hoVaTen" class="form-label">Họ
							và tên</label><span class="text-danger"> *</span> <input type="text"
							class="form-control" id="hoVaTen" name="hoVaTen" required value="<%=hoVaTen  %>" >
					</div>
					<div class=" ">
						<label for="gioiTinh" class="form-label">Giới
							tính</label> <select class="form-control" id="gioiTinh"   name="gioiTinh">
							<option></option>
							<option value="Nam" <%=(gioiTinh.equals("Nam"))?"selected='selected'":"" %>>Nam</option>
							<option value="Nữ" <%=(gioiTinh.equals("Nữ"))?"selected='selected'":"" %>>Nữ</option>
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
					<input type="submit" value="Cập nhật"
						class="btn btn-secondary" id="submit">
				</div>
			</div>
		</form>
	</div>
	<%}
	%>
</body>
</html>