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

import com.mysql.cj.Session;

import database.KhachHangDAO;

public class xuLyThayDoiThongTin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public xuLyThayDoiThongTin() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/thaydoithongtinthanhcong.jsp");
			rDispatcher.forward(request, response);
		} catch (Exception e) {
			session.setAttribute("khachHang", khachHang);
			request.setAttribute("baoLoiString", "chua cap nhat thanh cong"); 
			RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher("/thaydoithongtin.jsp");
			rDispatcher.forward(request, response);
		}
		
		
	}

}
