package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.khachHang;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.KhachHangDAO;

/**
 * Servlet implementation class xuLyDangKi
 */
public class xuLyDangKi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public xuLyDangKi() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/register.jsp");
			rDispatcher.forward(request, response);
		}
		else {
			String maKhachHangString = String.valueOf(System.currentTimeMillis()) ;
			khachHang khachHang = new khachHang(maKhachHangString, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,Date.valueOf(ngaySinh) , soDienThoai, email, dongYNhanMailString);
			KhachHangDAO.GetNew().insert(khachHang);
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/thanhcong.jsp");
			rDispatcher.forward(request, response);
		}
		
		
		
		
	}

}
