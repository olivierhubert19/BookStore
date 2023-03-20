package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.theLoai;

public class SanPhamDAO implements DAOinterface<SanPham> {

	public static SanPhamDAO GetNew() {
		return new SanPhamDAO();
	}

	@Override
	public ArrayList<SanPham> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM sanpham;";
			PreparedStatement pst = con.prepareStatement(url);
			ResultSet rs = pst.executeQuery();
			ArrayList<SanPham> res = new ArrayList<>();
			while (rs.next()) {
				String maSanPham = rs.getString("maSanPham");
				String tenSanPham = rs.getString("tenSanPham");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaNhap = rs.getDouble("giaNhap");
				double giaGoc = rs.getDouble("giaGoc");
				double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				String moTa = rs.getString("moTa");
				res.add(new SanPham(maSanPham, tenSanPham, new TacGia(maTacGia), namXuatBan, giaNhap, giaGoc, giaBan,
						soLuong, new theLoai(maTheLoai), ngonNgu, moTa));
			}
			return res;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public SanPham selectById(String O) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM sanPham WHERE maSanPham=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, O);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSanPham = rs.getString("maSanPham");
				String tenSanPham = rs.getString("tenSanPham");
				String maTacGia = rs.getString("maTacGia");
				int namXuatBan = rs.getInt("namXuatBan");
				double giaNhap = rs.getDouble("giaNhap");
				double giaGoc = rs.getDouble("giaGoc");
				double giaBan = rs.getDouble("giaBan");
				int soLuong = rs.getInt("soLuong");
				String maTheLoai = rs.getString("maTheLoai");
				String ngonNgu = rs.getString("ngonNgu");
				String moTa = rs.getString("moTa");
				return (new SanPham(maSanPham, tenSanPham, new TacGia(maTacGia), namXuatBan, giaNhap, giaGoc, giaBan,
						soLuong, new theLoai(maTheLoai), ngonNgu, moTa));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insert(SanPham t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO SanPham(maSanPham,tenSanPham,maTacGia,namXuatBan,giaNhap,giaGoc,giaBan,soLuong,maTheLoai,ngonNgu,moTa) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaSanPham());
			pst.setString(2, t.getTenSanPham());
			pst.setString(3, t.getTacgia().getMaTacGia());
			pst.setInt(4, t.getNamXuatban());
			pst.setDouble(5, t.getGiaNhap());
			pst.setDouble(6, t.getGiaGoc());
			pst.setDouble(7, t.getGiaBan());
			pst.setInt(8, t.getSoLuong());
			pst.setString(9, t.getTheLoai().getMaTheLoai());
			pst.setString(10, t.getNgonNgu());
			pst.setString(11, t.getMoTa());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<SanPham> t) {
		int res = 0;
		for (SanPham a : t) {
			this.insert(a);
			res++;
		}
		return res;
	}

	@Override
	public int delete(SanPham t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM sanpham WHERE maSanPham=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaSanPham());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> t) {
		int res = 0;
		for (SanPham a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int update(SanPham t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE SanPham SET moTa=? WHERE maSanPham = ?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMoTa());
			pst.setString(2, t.getMaSanPham());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

}