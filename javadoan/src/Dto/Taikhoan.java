package Dto;

public class Taikhoan {
	private String sdt;
	private String ten;	
	private String mk;
	private String chucvu;
	
	public Taikhoan(String sdt, String ten, String mk,String chucvu) {
		super();
		this.sdt = sdt;
		this.ten = ten;
		this.mk = mk;
		this.chucvu= chucvu;
	}
	public Taikhoan() {
		// TODO Auto-generated constructor stub
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMk() {
		return mk;
	}
	public void setMk(String mk) {
		this.mk = mk;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	
	
}

