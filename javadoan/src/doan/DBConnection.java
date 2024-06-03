package doan;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Dto.Donhang;
import Dto.Hoadon;
import Dto.Nhanvien;
import Dto.Sanpham;
import Dto.Sanpham1;
import Dto.Taikhoan;


public class DBConnection {
	static String url ="jdbc:mysql://localhost:3306/QL_CHQA";
	static String user ="root";
	static String password= "haily0910";
	public static Connection getConnection() {
		Connection connection= null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;		
	}	
	public static List<Nhanvien>findAll() {
		List<Nhanvien>nhanvienList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLyNhanVien";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Nhanvien nv = new Nhanvien(rs.getInt("manv"),rs.getString("tennv"),rs.getInt("sdt"),rs.getString("gioitinh"),rs.getString("ngayvaolv"),rs.getString("ngaysinh"),rs.getString("chucvu"),rs.getString("anh"));
				nhanvienList.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienList;
		
	}
	public static void xoa1(Nhanvien nv) {
    	String query = "delete from QL_CHQA.QuanLyNhanVien where manv='" + nv.getManv() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static List<Nhanvien> timkiem(Nhanvien nv1) {
		List<Nhanvien>nhanvienl= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLyNhanVien where Manv='"+nv1.getManv()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Nhanvien nv = new Nhanvien(rs.getInt("manv"),rs.getString("tennv"),rs.getInt("sdt"),rs.getString("gioitinh"),rs.getString("ngayvaolv"),rs.getString("ngaysinh"),rs.getString("chucvu"),rs.getString("anh"));
				nhanvienl.add(nv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienl;				
	}	
	public static List<Nhanvien> timkiem1(Nhanvien nv1) {
		List<Nhanvien>nhanvienl= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLyNhanVien where Tennv='"+nv1.getTennv()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Nhanvien nv = new Nhanvien(rs.getInt("manv"),rs.getString("tennv"),rs.getInt("sdt"),rs.getString("gioitinh"),rs.getString("ngayvaolv"),rs.getString("ngaysinh"),rs.getString("chucvu"),rs.getString("anh"));
				nhanvienl.add(nv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienl;				
	}	

	public static List<Sanpham>findAll2() {
		List<Sanpham>spList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham sp = new Sanpham(rs.getInt("maSp"),rs.getString("Chatlieu"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaNhap"),rs.getString("giaBan"),rs.getString("anh"));
				spList.add(sp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return spList;
		
	}
	public static List<Sanpham1>findAll22() {
		List<Sanpham1>spList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham1";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham1 sp1 = new Sanpham1(rs.getInt("masp"),rs.getString("tensp"),rs.getString("size"), rs.getInt("soluong"),rs.getString("giaban"));
				spList.add(sp1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return spList;
		
	}
	public static void xoa2(Sanpham sp) {
    	String query = "delete from QL_CHQA.QuanLySanPham where Masp='" + sp.getMaSp() + "'";
    	String query1 = "delete from QL_CHQA.QuanLySanPham1 where masp='" + sp.getMaSp() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			PreparedStatement pstmt1 = connection.prepareStatement(query1);
			pstmt1.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static List<Sanpham> timkiem2(Sanpham sanpham) {
		List<Sanpham>sp= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham where MaSp='"+sanpham.getMaSp()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham spham = new Sanpham(rs.getInt("maSp"),rs.getString("Chatlieu"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaNhap"),rs.getString("giaBan"),rs.getString("anh"));
				sp.add(spham);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	public static List<Sanpham> timkiem22(Sanpham sanpham) {
		List<Sanpham>sp= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham where TenSp='"+sanpham.getTenSp()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham spham = new Sanpham(rs.getInt("maSp"),rs.getString("Chatlieu"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaNhap"),rs.getString("giaBan"),rs.getString("anh"));
				sp.add(spham);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	public static List<Sanpham1> timkiem2a(Sanpham1 sanpham) {
		List<Sanpham1>sp= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham1 where MaSp='"+sanpham.getMasp()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham1 spham = new Sanpham1(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaBan"));
				sp.add(spham);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	public static List<Sanpham1> timkiem22a(Sanpham1 sanpham) {
		List<Sanpham1>sp= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.QuanLySanPham1 where tensp='"+sanpham.getTensp()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Sanpham1 spham = new Sanpham1(rs.getInt("maSp"),rs.getString("tenSp"),rs.getString("Size"),rs.getInt("soLuong"),rs.getString("giaBan"));
				sp.add(spham);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sp;
	}
	public static List<Donhang>findAll33() {
		List<Donhang>dh1List= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon2";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Donhang dh1 = new Donhang(rs.getInt("STT"),rs.getInt("Masp"),rs.getString("Tensp"),rs.getInt("soluong"),rs.getDouble("Dongia"),rs.getDouble("thanhtien"));
				dh1List.add(dh1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dh1List;
		
	}
	public static List<Hoadon>findAll333() {
		List<Hoadon>hdList= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Hoadon hd = new Hoadon(rs.getString("mahd"),rs.getString("ngayban"),rs.getDouble("tongtien"));
				hdList.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hdList;
		
	}
	public static List<Hoadon> timkiem333(Hoadon hoadon) {
		List<Hoadon>hd= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon where ngayban='"+hoadon.getNgayban()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Hoadon hdon = new Hoadon(rs.getString("mahd"),rs.getString("ngayban"),rs.getDouble("tongtien"));
				hd.add(hdon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hd;
	}
	public static List<Hoadon> timkiem334(Hoadon hoadon) {
		List<Hoadon>hd= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon where mahd='"+hoadon.getMahd()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Hoadon hdon = new Hoadon(rs.getString("mahd"),rs.getString("ngayban"),rs.getDouble("tongtien"));
				hd.add(hdon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hd;
	}
	public static List<Hoadon> timkiem335(Hoadon hoadon) {
		List<Hoadon>hd= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.Laphoadon where ngayban='"+hoadon.getNgayban()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Hoadon hdon = new Hoadon(rs.getString("mahd"),rs.getString("ngayban"),rs.getDouble("tongtien"));
				hd.add(hdon);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hd;
	}

	public static List<Taikhoan>findAll4() {
		List<Taikhoan>dn1List= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.DangNhap";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Taikhoan dn1 = new Taikhoan(rs.getString("Sdt"),rs.getString("Taikhoan"),rs.getString("Matkhau"),rs.getString("Chucvu"));
				dn1List.add(dn1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dn1List;
		
	}
	public static void xoa4(Taikhoan tk) {
    	String query = "delete from QL_CHQA.DangNhap where Sdt='" + tk.getSdt() + "'";
    	try {
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.executeUpdate();
			} catch (Exception e) {
			// TODO: handle exception
		}
    }
	public static List<Taikhoan> timkiem4(Taikhoan tk) {
		List<Taikhoan>tkhoan1= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.DangNhap where  taikhoan ='"+tk.getTen()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Taikhoan tk1 = new Taikhoan(rs.getString("Sdt"),rs.getString("Taikhoan"),rs.getString("Matkhau"),rs.getString("chucvu"));
				tkhoan1.add(tk1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tkhoan1;
	}
	public static List<Taikhoan> timkiem44(Taikhoan tk) {
		List<Taikhoan>tkhoan1= new ArrayList<>();
		String query ="SELECT * FROM QL_CHQA.DangNhap where sdt ='"+tk.getSdt()+"'";
		try {
			Connection connection = getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while (rs.next()) {
				Taikhoan tk1 = new Taikhoan(rs.getString("Sdt"),rs.getString("Taikhoan"),rs.getString("Matkhau"),rs.getString("chucvu"));
				tkhoan1.add(tk1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tkhoan1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      DBConnection db1 = new DBConnection();
    
	}
	
	

}

