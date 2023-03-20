package model;

import java.sql.Date;
import java.util.Objects;

public class donHang {
	
	private String maDonHang;
	private khachHang khachHang;
	private String diaChiMuaHang;
	private String diaChiNhanHang;
	private String hinhThucThanhToan;
	private double soTienDaThanhToan;
	private double soTienConThieu;
	private Date ngayDatHang;
	private Date ngayGiaoHang;

	public donHang() {
		super();
	}

	
	public donHang(String maDonHang) {
		super();
		this.maDonHang = maDonHang;
	}

	
	public donHang(String maDonHang, double soTienConThieu) {
		super();
		this.maDonHang = maDonHang;
		this.soTienConThieu = soTienConThieu;
	}


	public donHang(String maDonHang, model.khachHang khachHang, String diaChiMuaHang, String diaChiNhanHang,
			String hinhThucThanhToan, double soTienDaThanhToan, double soTienConThieu, Date ngayDatHang,
			Date ngayGiaoHang) {
		super();
		this.maDonHang = maDonHang;
		this.khachHang = khachHang;
		this.diaChiMuaHang = diaChiMuaHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.hinhThucThanhToan = hinhThucThanhToan;
		this.soTienDaThanhToan = soTienDaThanhToan;
		this.soTienConThieu = soTienConThieu;
		this.ngayDatHang = ngayDatHang;
		this.ngayGiaoHang = ngayGiaoHang;
	}

	public double getSoTienDaThanhToan() {
		return soTienDaThanhToan;
	}

	public void setSoTienDaThanhToan(double soTienDaThanhToan) {
		this.soTienDaThanhToan = soTienDaThanhToan;
	}

	public double getSoTienConThieu() {
		return soTienConThieu;
	}

	public void setSoTienConThieu(double soTienConThieu) {
		this.soTienConThieu = soTienConThieu;
	}

	public String getHinhThucThanhToan() {
		return hinhThucThanhToan;
	}

	public void setHinhThucThanhToan(String hinhThucThanhToan) {
		this.hinhThucThanhToan = hinhThucThanhToan;
	}

	
	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	
	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public khachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(khachHang khachHang) {
		this.khachHang = khachHang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	@Override
	public String toString() {
		return "donHang [maDonHang=" + maDonHang + ", diaChiNhanHang=" + diaChiNhanHang + ", soTienConThieu="
				+ soTienConThieu + "]";
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public Date getNgayGiaoHang() {
		return ngayGiaoHang;
	}

	public void setNgayGiaoHang(Date ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}

}