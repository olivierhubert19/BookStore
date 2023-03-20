package model;
public class chiTietDonHang{

	private String maChiTietDonHang;
	private donHang donHang;
	private SanPham SanPham;
	private int soLuong;
	private double giaBia;
	private double giaBan;
	private double giamGia;
	private double tongTien;
	
	
	
	public chiTietDonHang(String maChiTietDonHang, double giamGia) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.giamGia = giamGia;
	}
	public chiTietDonHang(String maChiTietDonHang, model.donHang donHang, model.SanPham sanPham, int soLuong,
			double giaBia, double giaBan, double giamGia, double tongTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.donHang = donHang;
		SanPham = sanPham;
		this.soLuong = soLuong;
		this.giaBia = giaBia;
		this.giaBan = giaBan;
		this.giamGia = giamGia;
		this.tongTien = tongTien;
	}
	public chiTietDonHang() {
		super();
	}
	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}
	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}
	public donHang getDonHang() {
		return donHang;
	}
	public void setDonHang(donHang donHang) {
		this.donHang = donHang;
	}
	
	public SanPham getSanPham() {
		return SanPham;
	}
	public void setSanPham(SanPham sanPham) {
		SanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaBia() {
		return giaBia;
	}
	public void setGiaBia(double giaBia) {
		this.giaBia = giaBia;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getGiamGia() {
		return giamGia;
	}
	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	@Override
	public String toString() {
		return "chiTietDonHang [maChiTietDonHang=" + maChiTietDonHang + ", tongTien=" + tongTien + "]";
	}
	
}