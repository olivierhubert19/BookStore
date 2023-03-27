package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.khachHang;

public class KhachHangDAO implements DAOinterface<khachHang> {
	public static KhachHangDAO GetNew() {
		return new KhachHangDAO();
	}

	public int ChanggeMatKhau(String tenDangNhap, String matKhauMoi) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE khachhang SET matkhau=? WHERE tendangnhap = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, matKhauMoi);
			pst.setString(2, tenDangNhap);
			int rs = pst.executeUpdate();
			String check = "";
			return rs;
		} catch (Exception e) {
		}
		return 0;
	}

	public int ChanggeInfor(String tenDangNhap, String thongtinDoi, String thongTinMoi) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE khachhang SET " + thongtinDoi + "=? WHERE tendangnhap = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, thongTinMoi);
			pst.setString(2, tenDangNhap);
			System.out.println(pst.toString());
			int rs = pst.executeUpdate();
			String check = "";
			return rs;
		} catch (Exception e) {
		}
		return 0;
	}

	public boolean ContainsTenDangNhap(String s) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM khachhang WHERE tendangnhap = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, s);
			ResultSet rs = pst.executeQuery();
			String check = "";
			if (rs.next())
				check = rs.getString("tendangnhap");
			if (check == "") {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
		}
		return true;
	}

	public khachHang ContainsAccount(String tenDangNhap, String matKhauString) {
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM khachhang WHERE tendangnhap= ? AND matkhau= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tenDangNhap);
			pst.setString(2, matKhauString);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				String makhachHang = rs.getString("makhachHang");
				String hovaten = rs.getString("hovaten");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				String dangkinhanemail = rs.getString("dangkinhanemail");
				return (new khachHang(makhachHang, tenDangNhap, matKhauString, hovaten, gioitinh, diachi, ngaysinh,
						sodienthoai, email, dangkinhanemail));
			}
			return null;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<khachHang> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM khachhang;";
			PreparedStatement pst = con.prepareStatement(url);
			ResultSet rs = pst.executeQuery();
			ArrayList<khachHang> res = new ArrayList<>();

			while (rs.next()) {
				String makhachHang = rs.getString("makhachhang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matkhau = rs.getString("matkhau");
				String hovaten = rs.getString("hovaten");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				String dangkinhanemail = rs.getString("dangkinhanemail");
				res.add(new khachHang(makhachHang, tenDangNhap, matkhau, hovaten, gioitinh, diachi, ngaysinh,
						sodienthoai, email, dangkinhanemail));

			}
			return res;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public khachHang selectById(String O) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM khachhang WHERE makhachhang=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, O);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String makhachHang = rs.getString("makhachHang");
				String tenDangNhap = rs.getString("tendangnhap");
				String matkhau = rs.getString("matkhau");
				String hovaten = rs.getString("hovaten");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				String dangkinhanemail = rs.getString("dangkinhanemail");
				String maxacthuc = rs.getString("maxacthuc");
				Date thoigianhieuluccuama = rs.getDate("thoigianhieuluccuama");
				boolean trangthaicuamaxacthuc = rs.getBoolean("trangthaicuamaxacthuc");
				return (new khachHang(makhachHang, tenDangNhap, matkhau, hovaten, gioitinh, diachi, ngaysinh, sodienthoai, email, dangkinhanemail, maxacthuc, thoigianhieuluccuama, trangthaicuamaxacthuc)
						);
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insert(khachHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO khachHang(makhachHang,tendangnhap,matkhau,hovaten,gioitinh,diachi,ngaysinh,sodienthoai,email,dangkinhanemail) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaKhachHang());
			pst.setString(2, t.getTenDangNhap());
			pst.setString(3, t.getMatKhau());
			pst.setString(4, t.getHoVaTen());
			pst.setString(5, t.getGioiTinh());
			pst.setString(6, t.getDiachi());
			pst.setDate(7, t.getNgaySinh());
			pst.setString(8, t.getSoDienThoai());
			pst.setString(9, t.getEmail());
			pst.setString(10, t.getdangKiNhanEmail());
		
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<khachHang> t) {
		int res = 0;
		for (khachHang a : t) {
			this.insert(a);
			res++;
		}
		return res;
	}

	@Override
	public int delete(khachHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM khachhang WHERE makhachhang=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaKhachHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<khachHang> t) {
		int res = 0;
		for (khachHang a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int update(khachHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE khachhang SET matkhau=? WHERE makhachhang = ?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getMaKhachHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}
	public int updateVerifyInformation(khachHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE khachhang SET maxacthuc=?,thoigianhieuluccuama=?,trangthaicuamaxacthuc=? WHERE makhachhang = ?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaXacThuc());
			pst.setDate(2, t.getThoiGianHieuLucCuaMaXacThuc());
			pst.setBoolean(3, t.isTrangThaiXacThuc());
			pst.setString(4,t.getMaKhachHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

}