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

import com.mysql.cj.Session;

import database.KhachHangDAO;

public class xuLyDoiMatKhau extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public xuLyDoiMatKhau() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		khachHang khachHang =(khachHang) session.getAttribute("khachHang");
		String matKhauHienTai = request.getParameter("matKhauHienTai");
		String matKhauMoi = request.getParameter("matKhauMoi");
		matKhauHienTai = MaHoa.toSHA1(matKhauHienTai);
		String url;
		if(!khachHang.getMatKhau().equals(matKhauHienTai)) {
			url="/doimatkhau.jsp";
			String baoLoi = "Nhap sai mat khau";
			request.setAttribute("baoLoi", baoLoi);
		}
		else {
			if(KhachHangDAO.GetNew().ChanggeMatKhau(khachHang.getTenDangNhap(), matKhauMoi)==1) {
				url="/doimatkhauthanhcong.jsp";
			}
			else {
				url="/doimatkhau.jsp";
				String baoLoi = "Doi mat khau chua thanh cong";
			}
			
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(url);
		rDispatcher.forward(request, response);
		
	}

}
