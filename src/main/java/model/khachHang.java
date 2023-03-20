package model;

import java.sql.Date;

public class khachHang {
	private String maKhachHang;
	private String tenDangNhap;
	private String matKhau;
	private String hoVaTen;
	private String gioiTinh;
	private String diachi;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private String dangKiNhanEmail;
	

	public khachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}

	public khachHang(String maKhachHang,String matKhau) {
		super();
		this.maKhachHang = maKhachHang;
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "khachHang [maKhachHang=" + maKhachHang + ", hoVaTen=" + hoVaTen + ", diachi=" + diachi
				+ ", soDienThoai=" + soDienThoai + "]";
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public khachHang(String maKhachHang, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
			String diachi, Date ngaySinh, String soDienThoai, String email,
			String dangKiNhanEmail) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioiTinh = gioiTinh;
		this.diachi = diachi;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKiNhanEmail = dangKiNhanEmail;
	}

	public khachHang() {
		super();
	}

	public String getdangKiNhanEmail() {
		return dangKiNhanEmail;
	}

	public void setDangKiNhanEmail(String dangKiNhanEmail) {
		this.dangKiNhanEmail = dangKiNhanEmail;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}