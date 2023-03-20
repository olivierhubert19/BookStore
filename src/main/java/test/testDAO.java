package test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import database.ChiTietDonHangDAO;
import database.KhachHangDAO;
import database.SanPhamDAO;
import database.TacGiaDAO;
import database.donHangDAO;
import database.theLoaiDAO;
import model.SanPham;
import model.TacGia;
import model.chiTietDonHang;
import model.donHang;
import model.khachHang;
import model.theLoai;

public class testDAO{
	public static void main(String[] args) throws ParseException {
//		Scanner sc = new Scanner(System.in);
//		String maSanPham, tenSanPham, maTacGia, maTheLoai, ngonNgu, moTa;
//		int namXuatBan, soLuong;
//		double giaNhap, giaGoc, giaBan;
//		maSanPham = sc.next();
//		tenSanPham = sc.next();
//		maTacGia = sc.next();
//		namXuatBan = sc.nextInt();
//		giaNhap = sc.nextDouble();
//		giaGoc = sc.nextDouble();
//		giaBan = sc.nextDouble();
//		soLuong = sc.nextInt();
//		maTheLoai = sc.next();
//		ngonNgu = sc.next();
//		moTa = sc.next();
//		
//		SanPham a = new SanPham(maSanPham, tenSanPham, new TacGia(maTacGia), namXuatBan, giaNhap, giaGoc, giaBan, soLuong, new theLoai(maTheLoai), ngonNgu, moTa);
//		
//		System.out.println(SanPhamDAO.GetNew().insert(a)); 
		System.out.println(KhachHangDAO.GetNew().ContainsTenDangNhap("abc123"));
		
	}
}