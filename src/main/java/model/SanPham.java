package model;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private TacGia tacgia;
	private int namXuatban;
	private double giaNhap;
	private double giaGoc;
	private double giaBan;
	private int soLuong;
	private theLoai theLoai;
	private String ngonNgu;
	private String moTa;

	

	public SanPham(String maSanPham, String moTa) {
		super();
		this.maSanPham = maSanPham;
		this.moTa = moTa;
	}



	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}



	public double getGiaGoc() {
		return giaGoc;
	}

	

	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", soLuong=" + soLuong + "]";
	}



	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	public SanPham(String maSanPham, String tenSanPham, TacGia tacgia, int namXuatban, double giaNhap, double giaGoc,
			double giaBan, int soLuong, model.theLoai theLoai, String ngonNgu, String moTa) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.tacgia = tacgia;
		this.namXuatban = namXuatban;
		this.giaNhap = giaNhap;
		this.giaGoc = giaGoc;
		this.giaBan = giaBan;
		this.soLuong = soLuong;
		this.theLoai = theLoai;
		this.ngonNgu = ngonNgu;
		this.moTa = moTa;
	}

	public SanPham() {
		super();
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public TacGia getTacgia() {
		return tacgia;
	}

	public void setTacgia(TacGia tacgia) {
		this.tacgia = tacgia;
	}

	public int getNamXuatban() {
		return namXuatban;
	}

	public void setNamXuatban(int namXuatban) {
		this.namXuatban = namXuatban;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public theLoai getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(theLoai theLoai) {
		this.theLoai = theLoai;
	}

	public String getNgonNgu() {
		return ngonNgu;
	}

	public void setNgonNgu(String ngonNgu) {
		this.ngonNgu = ngonNgu;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

}