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

import database.KhachHangDAO;


public class xuLyDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public xuLyDangNhap() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenDangNhap = request.getParameter("tenDangNhap");
		String Password = request.getParameter("Password");
		Password = MaHoa.toSHA1(Password);
		String url="";
		khachHang khachHang = KhachHangDAO.GetNew().ContainsAccount(tenDangNhap, Password);
		if(khachHang!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("khachHang", khachHang);
			url = "/Index.jsp";
		}
		else {
			request.setAttribute("baoLoi", "Ten dang nhap hoac mat khau khong dung vui long nhap lai");
			url="/dangnhap.jsp";
		}
		RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(url);
		rDispatcher.forward(request, response);
	}

}
