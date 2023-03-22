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
<script type="text/javascript">
function Check() {
	var a = document.getElementById("matKhauMoi").value;
	var b = document.getElementById("nhapLaiMatKhauMoi").value;
	if(a==b){
		document.getElementById("submit").style.visibility="visible";
		 document.getElementById("loiMatKhauNhapLai").innerHTML="";
		}
	else{
		document.getElementById("submit").style.visibility="hidden";
		 document.getElementById("loiMatKhauNhapLai").innerHTML="Khong giong voi mat khau moi";
		}
}
</script>
	<% khachHang khachHang =(khachHang) session.getAttribute("khachHang");
		session.setAttribute("khachHang", khachHang);
		String baoLoi = (String) request.getAttribute("baoLoi")+"";
		if(baoLoi.equals("null")) baoLoi="";
	%>
	<main>
	<h1>ĐỔI MẬT KHẨU</h1>
	<div class="container col-6">
	<form action="xuLyDoiMatKhau" method="post">
	<div class="text-danger"><%= baoLoi %></div>
  <div class="mb-3">
    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại </label>
    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
  </div>
   <div class="mb-3">
    <label for="nhapLaiMatKhauMoi" class="form-label">Xác nhận mật khẩu </label>
    <input type="password" class="form-control" id="nhapLaiMatKhauMoi" onkeyup="Check()">
  </div>
  <div id="loiMatKhauNhapLai" class="text-danger"></div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  <button type="submit" class="btn btn-primary" style="visibility: hidden" id="submit" >Xác nhận</button>
</form>
</div>
	</main>
</body>
</html>