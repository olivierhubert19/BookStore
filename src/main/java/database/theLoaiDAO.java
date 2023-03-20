package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.theLoai;

public class theLoaiDAO implements DAOinterface<theLoai> {

	public static theLoaiDAO getNew() {
		return new theLoaiDAO();
	}

	@Override
	public ArrayList<theLoai> selectAll() {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM theloai;";
			PreparedStatement pst = con.prepareStatement(url);
			ResultSet rs = pst.executeQuery();
			ArrayList<theLoai> res = new ArrayList<>();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				res.add(new theLoai(maTheLoai, tenTheLoai));
			}
			return res;
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public theLoai selectById(String O) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM theloai WHERE matheLoai=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, O);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTheLoai = rs.getString("maTheLoai");
				String tenTheLoai = rs.getString("tenTheLoai");
				return new theLoai(maTheLoai, tenTheLoai);
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public int insert(theLoai t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO theloai(maTheLoai,tenTheLoai) " + "VALUES (?,?);";
			PreparedStatement pst = con.prepareStatement(url);

			pst.setString(1, t.getMaTheLoai());
			pst.setString(2, t.getTenTheLoai());
			System.out.println(pst.toString());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<theLoai> t) {
		int res = 0;
		for (theLoai a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int delete(theLoai t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM theLoai WHERE maTheLoai=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaTheLoai());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<theLoai> t) {
		int res = 0;
		for (theLoai a : t) {
			res += this.delete(a);
		}
		return res;
	}

	@Override
	public int update(theLoai t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE theloai SET tenTheLoai=? WHERE maTheLoai =?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaTheLoai());
			pst.setString(2, t.getTenTheLoai());
			int res = pst.executeUpdate();
			return res;
		} catch (Exception e) {

		}
		return 0;
	}

}