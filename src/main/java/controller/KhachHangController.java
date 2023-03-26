package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.khachHang;
import util.MaHoa;

import java.io.IOException;
import java.sql.Date;

import database.KhachHangDAO;

public class KhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KhachHangController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {
			dangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		} else if (hanhDong.equals("dang-ki")) {
			dangKi(request, response);
		} else if (hanhDong.equals("thay-doi-thong-tin")) {
			thayDoiThongTin(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String Password = request.getParameter("Password");
		Password = MaHoa.toSHA1(Password);
		String url = "";
		khachHang khachHang = KhachHangDAO.GetNew().ContainsAccount(tenDangNhap, Password);
		if (khachHang != null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			url = "/Index.jsp";
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(url);
			rDispatcher.forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("baoLoi", "Ten dang nhap hoac mat khau khong dung vui long nhap lai");
			response.sendRedirect("khachhang/dangnhap.jsp");
		}
		
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		// Huy bo session
		session.invalidate();

		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		response.sendRedirect(url + "/Index.jsp");
	}

	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachHang khachHang = (khachHang) session.getAttribute("khachHang");
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		matKhauHienTai = MaHoa.toSHA1(matKhauHienTai);
		String url;
		if (!khachHang.getMatKhau().equals(matKhauHienTai)) {
			url = "/khachhang/doimatkhau.jsp";
			String baoLoi = "Nhap sai mat khau";
			request.setAttribute("baoLoi", baoLoi);
		} else {
			if (KhachHangDAO.GetNew().ChanggeMatKhau(khachHang.getTenDangNhap(), MaHoa.toSHA1(matKhauMoi)) == 1) {
				url = "/khachhang/doimatkhauthanhcong.jsp";
			} else {
				url = "/khachhang/doimatkhau.jsp";
				String baoLoi = "Doi mat khau chua thanh cong";
			}

		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}
	private void dangKi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");
		String matKhau = request.getParameter("matKhau");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		String dongYNhanMailString= request.getParameter("dongYNhanMailQuangCao")+"";
		if(dongYNhanMailString.equals("on")) dongYNhanMailString="yes";
		else dongYNhanMailString="no";
		if (KhachHangDAO.GetNew().ContainsTenDangNhap(tenDangNhap)) {
			String baoLoiString = "Da co ten dang nhap trong he thong vui long nhap lai";
			request.setAttribute("tenDangNhap",tenDangNhap);
			request.setAttribute("soDienThoai",soDienThoai);
			request.setAttribute("email",email);
			request.setAttribute("matKhau",matKhau);
			request.setAttribute("hoVaTen",hoVaTen);
			request.setAttribute("diaChi",diaChi);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("baoLoiString", baoLoiString);
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/khachhang/register.jsp");
			rDispatcher.forward(request, response);
		}
		else {
			matKhau = MaHoa.toSHA1(matKhau);
			String maKhachHangString = String.valueOf(System.currentTimeMillis()) ;
			khachHang khachHang = new khachHang(maKhachHangString, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,Date.valueOf(ngaySinh) , soDienThoai, email, dongYNhanMailString);
			KhachHangDAO.GetNew().insert(khachHang);
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/khachhang/thanhcong.jsp");
			rDispatcher.forward(request, response);
		}
	}
	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachHang khachHang = (khachHang)session.getAttribute("khachHang");
		
		String tenDangNhap = khachHang.getTenDangNhap();
		String email = request.getParameter("email");
		String soDienThoai = request.getParameter("soDienThoai");
		String hoVaTen = request.getParameter("hoVaTen");
		String gioiTinh = request.getParameter("gioiTinh");
		String ngaySinh = request.getParameter("ngaySinh");
		String diaChi = request.getParameter("diaChi");
		try {
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"email", email);
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"sodienthoai", soDienThoai);
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"hovaten", hoVaTen);
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"gioitinh", gioiTinh);
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"ngaysinh", ngaySinh);
			KhachHangDAO.GetNew().ChanggeInfor(tenDangNhap,"diachi", diaChi);
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/khachhang/thaydoithongtinthanhcong.jsp");
			rDispatcher.forward(request, response);
		} catch (Exception e) {
			session.setAttribute("khachHang", khachHang);
			request.setAttribute("baoLoiString", "chua cap nhat thanh cong"); 
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/khachhang/thaydoithongtin.jsp");
			rDispatcher.forward(request, response);
		}
	}
}
