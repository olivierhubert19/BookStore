package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.SanPham;
import model.chiTietDonHang;
import model.donHang;
import model.khachHang;

public class ChiTietDonHangDAO implements DAOinterface<chiTietDonHang> {
	public static ChiTietDonHangDAO GetNew() {
		return new ChiTietDonHangDAO();
	}

	@Override
	public ArrayList<chiTietDonHang> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM chitietdonhang;";
			PreparedStatement pst = con.prepareStatement(url);
			ResultSet rs = pst.executeQuery();
			ArrayList<chiTietDonHang> res = new ArrayList<>();

			while (rs.next()) {
				String maChiTietDonHang = rs.getString("maChiTietDonHang");
				String maDonHang = rs.getString("maDonHang");
				String maSanPham = rs.getString("maSanPham");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giaBan = rs.getDouble("giaBan");
				double giamGia = rs.getDouble("giamGia");
				double tongTien = rs.getDouble("tongTien");
				res.add(new chiTietDonHang(maChiTietDonHang, new donHang(maDonHang), new SanPham(maSanPham), soLuong,
						giaBia, giaBan, giamGia, tongTien));

			}
			return res;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public chiTietDonHang selectById(String O) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM chiTietDonHang WHERE machiTietDonHang=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, O);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maChiTietDonHang = rs.getString("maChiTietDonHang");
				String maDonHang = rs.getString("maDonHang");
				String maSanPham = rs.getString("maSanPham");
				int soLuong = rs.getInt("soLuong");
				double giaBia = rs.getDouble("giaBia");
				double giaBan = rs.getDouble("giaBan");
				double giamGia = rs.getDouble("giamGia");
				double tongTien = rs.getDouble("tongTien");
				return (new chiTietDonHang(maChiTietDonHang, new donHang(maDonHang), new SanPham(maSanPham), soLuong,
						giaBia, giaBan, giamGia, tongTien));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insert(chiTietDonHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO chiTietDonHang(maChiTietDonHang,maDonHang,maSanPham,soLuong,giaBia,giaBan,giamGia,tongTien)"
					+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaChiTietDonHang());
			pst.setString(2, t.getDonHang().getMaDonHang());
			pst.setString(3, t.getSanPham().getMaSanPham());
			pst.setInt(4, t.getSoLuong());
			pst.setDouble(5, t.getGiaBia());
			pst.setDouble(6, t.getGiaBan());
			pst.setDouble(5, t.getGiamGia());
			pst.setDouble(5, t.getTongTien());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<chiTietDonHang> t) {
		int res = 0;
		for (chiTietDonHang a : t) {
			this.insert(a);
			res++;
		}
		return res;
	}

	@Override
	public int delete(chiTietDonHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM chitietdonhang WHERE maChiTietDonHang=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaChiTietDonHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<chiTietDonHang> t) {
		int res = 0;
		for (chiTietDonHang a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int update(chiTietDonHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE chiTietDonHang SET giamGia=? WHERE machiTietDonHang = ?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setDouble(1, t.getGiamGia());
			pst.setString(2, t.getMaChiTietDonHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}
}