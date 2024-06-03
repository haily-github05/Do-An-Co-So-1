package Dto;

public class Sanpham1 {
	int masp;
	String tensp,size;
	int soluong;
	String giaban;
	public Sanpham1(int masp, String tensp,  String size, int soluong, String giaban) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.size = size;
		this.soluong = soluong;
		this.giaban = giaban;
	}
	public Sanpham1() {
		// TODO Auto-generated constructor stub
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

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiaban() {
		return giaban;
	}
	public void setGiaban(String giaban) {
		this.giaban = giaban;
	}
	
	


}
