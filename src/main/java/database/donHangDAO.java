package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.donHang;
import model.khachHang;

public class donHangDAO implements DAOinterface<donHang> {
	public static donHangDAO GetNew() {
		return new donHangDAO();
	}

	@Override
	public ArrayList<donHang> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM donhang;";
			PreparedStatement pst = con.prepareStatement(url);
			ResultSet rs = pst.executeQuery();
			ArrayList<donHang> res = new ArrayList<>();

			while (rs.next()) {
				String madonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiMuaHang = rs.getString("diaChiMuaHang");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
				double soTienConThieu = rs.getDouble("soTienConThieu");
				Date ngayDatHang = rs.getDate("ngayDatHang");
				Date ngayGiaoHang = rs.getDate("ngayGiaoHang");
				res.add(new donHang(madonHang, new khachHang(maKhachHang), diaChiMuaHang, diaChiNhanHang, hinhThucThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang));

			}
			return res;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public donHang selectById(String O) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM donhang WHERE maDonHang=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, O);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String madonHang = rs.getString("maDonHang");
				String maKhachHang = rs.getString("maKhachHang");
				String diaChiMuaHang = rs.getString("diaChiMuaHang");
				String diaChiNhanHang = rs.getString("diaChiNhanHang");
				String hinhThucThanhToan = rs.getString("hinhThucThanhToan");
				double soTienDaThanhToan = rs.getDouble("soTienDaThanhToan");
				double soTienConThieu = rs.getDouble("soTienConThieu");
				Date ngayDatHang = rs.getDate("ngayDatHang");
				Date ngayGiaoHang = rs.getDate("ngayGiaoHang");
				return (new donHang(madonHang, new khachHang(maKhachHang), diaChiMuaHang, diaChiNhanHang, hinhThucThanhToan, soTienDaThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang));
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insert(donHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO donHang(maDonHang,maKhachHang,diaChiMuaHang,diaChiNhanHang,hinhThucThanhToan,soTienDaThanhToan,soTienConThieu,ngayDatHang,ngayGiaoHang) "
					+ "VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaDonHang());
			pst.setString(2, t.getKhachHang().getMaKhachHang());
			pst.setString(3, t.getDiaChiMuaHang());
			pst.setString(4, t.getDiaChiNhanHang());
			pst.setString(5, t.getHinhThucThanhToan());
			pst.setDouble(6, t.getSoTienDaThanhToan());
			pst.setDouble(7, t.getSoTienConThieu());
			pst.setDate(8, t.getNgayDatHang());
			pst.setDate(8, t.getNgayGiaoHang());

			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<donHang> t) {
		int res = 0;
		for (donHang a : t) {
			this.insert(a);
			res++;
		}
		return res;
	}

	@Override
	public int delete(donHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM donhang WHERE maDonHang=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaDonHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<donHang> t) {
		int res = 0;
		for (donHang a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int update(donHang t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE donhang SET soTienConThieu=? WHERE maDonHang = ?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setDouble(1, t.getSoTienConThieu());
			pst.setString(2, t.getMaDonHang());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}
}