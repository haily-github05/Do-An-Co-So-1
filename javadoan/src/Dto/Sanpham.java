package Dto;

import java.util.ArrayList;
import java.util.List;

public class Sanpham {
    private int maSp; 
    private String chatLieu;
    private String tenSp;
    private String size;
    private int soLuong;
    private String giaNhap,giaBan;
    private String anh;
	public Sanpham(int maSp, String chatLieu, String tenSp, String size, int soLuong, String giaNhap, String giaBan,
			String anh) {
		super();
		this.maSp = maSp;
		this.chatLieu = chatLieu;
		this.tenSp = tenSp;
		this.size = size;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.anh = anh;
	}
	public Sanpham() {
		// TODO Auto-generated constructor stub
	}
	public int getMaSp() {
		return maSp;
	}
	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}
	public String getChatLieu() {
		return chatLieu;
	}
	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(String giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
    
}
