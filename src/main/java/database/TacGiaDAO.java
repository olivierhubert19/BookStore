package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.TacGia;

public class TacGiaDAO implements DAOinterface<TacGia>{
	
	public static TacGiaDAO getNew() {
		return new TacGiaDAO();
	}
	
	@Override
	public ArrayList<TacGia> selectAll() {
		try {
		Connection con = JDBCUtil.getConnection();
		String url = "SELECT * FROM tacgia;";
		PreparedStatement pst = con.prepareStatement(url);
		ResultSet rs = pst.executeQuery();
		ArrayList<TacGia> res = new ArrayList<>();
		while(rs.next()) {
			String maTacGia = rs.getString("maTacGia");
			String hoVaTen = rs.getString("hoVaTen");
			Date ngaySinh = rs.getDate("ngaySinh");
			String tieuSu = rs.getString("tieuSu");
			res.add(new TacGia(maTacGia,hoVaTen,ngaySinh,tieuSu));
		}
		return res;
		}
		catch (Exception e){
			
		}
		return null;
	}
	@Override
	public TacGia selectById(String id) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "SELECT * FROM tacgia WHERE maTacGia=?";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maTacGia = rs.getString("maTacGia");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String tieuSu = rs.getString("tieuSu");
				return new TacGia(maTacGia,hoVaTen,ngaySinh,tieuSu);
			}
			}
			catch (Exception e){
				
			}
			return null;
	}
	@Override
	public int insert(TacGia t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "INSERT INTO tacgia(maTacGia,hoVaTen,ngaySinh,tieuSu) "					
			+ "VALUES (?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getMaTacGia());
			pst.setString(2, t.getHoVaTen());
			pst.setDate(3, t.getNgaySinh());
			pst.setString(4, t.getTieuSu());
			int res = pst.executeUpdate();
			return res;
			}
			catch (Exception e){
				
			}
		return 0;
	}
	@Override
	public int deleteAll(ArrayList<TacGia> t) {
		int res=0;
		for(TacGia a:t) {
			res+=this.delete(a);
		}
		return res;
	}
	@Override
	public int insertAll(ArrayList<TacGia> t) {
		int res=0;
		for(TacGia a:t) {
			this.insert(a);
			res++;
		}
		return res;
	}
	@Override
	public int delete(TacGia t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "DELETE FROM tacgia WHERE maTacGia=?;";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1,t.getMaTacGia());
			int res = pst.executeUpdate();
			return res;
			}
			catch (Exception e){
				
			}
		return 0;
	}
	@Override
	public int update(TacGia t) {
		try {
			Connection con = JDBCUtil.getConnection();
			String url = "UPDATE tacgia SET tieuSu=? WHERE maTacGia =?;"					
			+ "VALUES (?,?);";
			PreparedStatement pst = con.prepareStatement(url);
			pst.setString(1, t.getTieuSu());
			pst.setString(2, t.getMaTacGia());
			int res = pst.executeUpdate();
			return res;
			}
			catch (Exception e){
				
			}
		return 0;
	}
}