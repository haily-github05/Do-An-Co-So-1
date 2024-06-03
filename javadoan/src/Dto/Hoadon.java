package Dto;

public class Hoadon {
	String mahd,ngayban;
	double tongtien;

	public Hoadon(String mahd, String ngayban, Double tongtien) {
		super();
		this.mahd = mahd;
		this.ngayban = ngayban;
		this.tongtien = tongtien;
	}

	public Hoadon() {
		// TODO Auto-generated constructor stub
	}

	public String getMahd() {
		return mahd;
	}

	public void setMahd(String mahd) {
		this.mahd = mahd;
	}

	public String getNgayban() {
		return ngayban;
	}

	public void setNgayban(String ngayban) {
		this.ngayban = ngayban;
	}

	public Double getTongtien() {
		return tongtien;
	}

	public void setTongtien(Double tongtien) {
		this.tongtien = tongtien;
	}
	

}
