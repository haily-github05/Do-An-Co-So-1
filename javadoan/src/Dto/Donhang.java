package Dto;

public class Donhang {
	int stt,masp;
	String tensp;
	int soluong;
	Double dongia,thanhtien;
	public Donhang(int stt, int masp, String tensp, int soluong, Double dongia, Double thanhtien) {
		super();
		this.stt = stt;
		this.masp = masp;
		this.tensp = tensp;
		this.soluong = soluong;
		this.dongia = dongia;
		this.thanhtien = thanhtien;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getMasp() {
		return masp;
	}
	public void setMasp(int masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Double getDongia() {
		return dongia;
	}
	public void setDongia(Double dongia) {
		this.dongia = dongia;
	}
	public Double getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(Double thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
