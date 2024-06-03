package doan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.jdbc.NClob;

import Dto.Sanpham;

public class QLSP extends JFrame {
	private static JTable tbl = new JTable();
	private JLabel a;
	private String imagePath;	
	public QLSP() {
		setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY" );
		setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel,BorderLayout.CENTER);
        Container container = getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setPreferredSize(new Dimension(190,765));;
        panel.add(panel1);       
//add Ảnh
        ImageIcon anh = new ImageIcon("///Users/hohaily/eclipse-workspace/java1/src/picture/Logo.png");
        Image scaledImage = anh.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        anh= new ImageIcon(scaledImage);
        JLabel panel11 = new JLabel(anh,JLabel.RIGHT);
        panel11.setIcon(anh);      
        panel1.add(panel11);

        JPanel panel12 = new JPanel();
        panel12.setBackground(Color.pink);
        panel12.setPreferredSize(new Dimension(190,500));;
        panel1.add(panel12);
        
        JLabel lbltk = new JLabel("Tài khoản:");
	    JTextField txttk = new JTextField();
	    txttk.setPreferredSize(new Dimension(80,30));
	    Dangnhap.tk(txttk);
	    txttk.setEditable(false);
	    JButton out = new JButton("Đăng xuất ");
        out.setPreferredSize(new Dimension(100,40)); 
        JButton quanlynhanvien = new JButton("Quản lý nhân viên ");
        quanlynhanvien.setPreferredSize(new Dimension(180,60)); 
        JButton quanlysanpham = new JButton("Quản lý sản phẩm ");
        quanlysanpham.setPreferredSize(new Dimension(180,60));
        JButton quanlydonhang = new JButton("Lập hoá đơn ");          
        quanlydonhang.setPreferredSize(new Dimension(180,60));
        JButton thongke = new JButton("Thống kê doanh số ");
        thongke.setPreferredSize(new Dimension(180, 60));
        JButton quanlydangnhap = new JButton("Quản lý đăng nhập ");          
        quanlydangnhap.setPreferredSize(new Dimension(180,60));        
        panel12.add(lbltk);
        panel12.add(txttk);
        panel12.add(out);
        panel12.add(quanlynhanvien);
        panel12.add(quanlysanpham);
        panel12.add(quanlydonhang);
        panel12.add(thongke);
        panel12.add(quanlydangnhap);

//      
        JPanel panelquanlysanpham = new JPanel();
        panelquanlysanpham.setBackground(Color.pink);
        panelquanlysanpham.setPreferredSize(new Dimension(1200,765));
        panel.add(panelquanlysanpham);
        
        JLabel jLabel_2= new JLabel("Quản Lý Sản Phẩm",JLabel.CENTER);
        Font font2 = new Font("Serif",Font.CENTER_BASELINE,50);
  	    jLabel_2.setFont(font2); 
        jLabel_2.setBackground(Color.pink);
        jLabel_2.setOpaque(true);
  	    panelquanlysanpham.add(jLabel_2,BorderLayout.NORTH);
  	    
  	    JPanel pn2 = new JPanel();
  	    pn2.setBackground(Color.pink);
      	pn2.setPreferredSize(new Dimension(1200,180));
  	    panelquanlysanpham.add(pn2);

		JPanel pn21 = new JPanel (new GridLayout(4,8));
		pn21.setBackground(Color.pink);
		pn21.setPreferredSize(new Dimension(1000,140));
		pn2.add(pn21,BorderLayout.WEST);

		JPanel pn22 = new JPanel();
		pn22.setBackground(Color.pink);
		pn22.setPreferredSize(new Dimension(160,170));
		pn2.add(pn22);
		a =new JLabel(" ");
		a.setPreferredSize(new Dimension(150,160));
	    pn22.add(a);	    

    	JLabel lblMasp = new JLabel("    Mã sản phẩm:");
        JTextField txtMasp = new JTextField();
    	JLabel lblchatlieu = new JLabel("    Chất liệu:");
    	JTextField txtchatlieu = new JTextField();
    	JLabel lblTensp = new JLabel("    Tên sản phẩm:");
    	JTextField txtTen = new JTextField();
    	JLabel lblsz = new JLabel("    Size");
    	JComboBox<String> txtsz = new JComboBox<>(new String[]{"","S","M","L","XL","2XL"});    	
  	    JLabel lblSoluong = new JLabel("    Số lượng:");
  	    JTextField txtSoluong = new JTextField();
  	    JLabel lblGianhap = new JLabel("    Giá nhập:");
  	    JTextField txtGianhap = new JTextField(); 
  	    JLabel lblGiaban = new JLabel("    Giá bán:");
  	    JTextField txtGiaban = new JTextField();
  	    JButton btnChonAnh = new JButton("Chọn ảnh");
  	    btnChonAnh.setPreferredSize(new Dimension(150, 20));
  	    
  	    pn21.add(lblMasp);
  	    pn21.add(txtMasp);
  	    pn21.add(lblchatlieu);
  	    pn21.add(txtchatlieu);
     	pn21.add(lblTensp);
    	pn21.add(txtTen);
    	pn21.add(lblsz);
    	pn21.add(txtsz);
    	pn21.add(lblSoluong);
    	pn21.add(txtSoluong);
    	pn21.add(lblGianhap);
    	pn21.add(txtGianhap);   
    	pn21.add(lblGiaban);
    	pn21.add(txtGiaban);
    	pn21.add(btnChonAnh);
	
    	JPanel pn2a= new JPanel(); 
    	pn2a.setBackground(Color.pink);
        pn2a.setPreferredSize(new Dimension(1200,580));
        panelquanlysanpham.add(pn2a,BorderLayout.SOUTH);

        JButton btnThem2 = new JButton("Thêm");
     	JButton btnXoa2 = new JButton("Xóa");
    	JButton btnSua2 = new JButton("Sửa");
    	pn2a.add(btnThem2);
    	pn2a.add(btnXoa2);  
    	pn2a.add(btnSua2);
   
    	DefaultTableModel dm=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	    };
    	dm.addColumn("Mã sản phẩm");
    	dm.addColumn("Chất liệu");
    	dm.addColumn("Tên sản phẩm");
    	dm.addColumn("Size");
    	dm.addColumn("Số lượng");
    	dm.addColumn("Giá nhập");
    	dm.addColumn("Giá bán");
    	dm.addColumn("Ảnh"); 
    	tbl =new JTable(dm);
    	JScrollPane sc=new JScrollPane(tbl);
    	sc.setPreferredSize(new Dimension(1190,355));
    	pn2a.add(sc,BorderLayout.SOUTH);
    	showData(DBConnection.findAll2());
  	
    	JPanel pn2b= new JPanel();
    	pn2b.setBackground(Color.pink);  
        pn2b.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem = new JButton("Tìm kiếm theo Mã");
    	JTextField txttimkiem= new JTextField(20);
    	pn2a.add(pn2b); 
    	pn2a.add(txttimkiem);
    	pn2a.add(btntimkiem);
    	
    	JPanel pn2c= new JPanel();
    	pn2c.setBackground(Color.pink); 
    	pn2c.setPreferredSize(new Dimension(705,5));
    	JButton btntimkiem2 = new JButton("Tìm kiếm theo Tên");
    	JTextField txttimkiem2= new JTextField(20);
    	pn2a.add(pn2c);
        pn2a.add(txttimkiem2);
    	pn2a.add(btntimkiem2);
    	JButton ql2 = new JButton("Quay lại");
    	ql2.setVisible(false);   	
    	pn2a.add(ql2);
    	
    	txtMasp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtchatlieu.requestFocus();
			}
		});
    	txtchatlieu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTen.requestFocus();
			}
		});
    	txtTen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtsz.requestFocus();
			}
		});
    	txtsz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtSoluong.requestFocus();
			}
		});
    	txtSoluong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtGianhap.requestFocus();
			}
		});
    	txtGianhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtGiaban.requestFocus();
			}
		});
 //chuc nang cac nut   	
    	btnChonAnh.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFileChooser fileChooser = new JFileChooser();
                 int result = fileChooser.showOpenDialog(QLSP.this);
                 if (result == JFileChooser.APPROVE_OPTION) {
                     File selectedFile = fileChooser.getSelectedFile();
                     imagePath = selectedFile.getAbsolutePath();
                     displayImage2(imagePath);
                 }
             }
         });
    	 btnThem2.addActionListener(new ActionListener() {
    		    @Override
    		    public void actionPerformed(ActionEvent e) {
    		        try {
    		            int maSp = Integer.parseInt(txtMasp.getText());
    		            String chatlieu = txtchatlieu.getText();
    		            String tenSp = txtTen.getText();
    		            String size = txtsz.getSelectedItem().toString();
    		            int soLuong = Integer.parseInt(txtSoluong.getText());
    		            String giaNhap = txtGianhap.getText();
    		            String giaBan = txtGiaban.getText();
    		            String anh = imagePath;

    		            DefaultTableModel model = (DefaultTableModel) tbl.getModel();
    		            model.addRow(new Object[]{maSp, chatlieu, tenSp, size, soLuong, giaNhap, giaBan, anh});
    		            saveImageToDatabase(imagePath, maSp);
    		            String url ="jdbc:mysql://localhost:3306/QL_CHQA";
    	                String user ="root";
    	    	        String password= "haily0910";
    	    	        String sqlThem2 = "INSERT INTO QL_CHQA.QuanLySanPham (maSp,Chatlieu,tenSP,size,soLuong, giaNhap,giaBan,anh) VALUES (?,?,?,?, ?, ?, ?, ?)";
    	    	        String sqlThem = "INSERT INTO QL_CHQA.QuanLySanPham1 (maSp,tenSP,size,soLuong,giaBan) VALUES (?,?,?,?, ?)";
    	    	       try {
    	    	    	   Connection connection = DriverManager.getConnection(url, user, password);	    	     
    	    	           PreparedStatement pstmt = connection.prepareStatement(sqlThem2);
    	    	           PreparedStatement pstmt1 = connection.prepareStatement(sqlThem);
    	    	           pstmt.setInt(1, maSp);
    	    	           pstmt.setString(2, chatlieu);
    	    	           pstmt.setString(3, tenSp);
    	    	           pstmt.setString(4, size);
    	    	           pstmt.setInt(5, soLuong);
    	    	           pstmt.setString(6, giaNhap);
    	    	           pstmt.setString(7, giaBan);
    	    	           pstmt.setString(8, anh); 
    	    	           pstmt.executeUpdate();
    	    	           
    	    	           pstmt1.setInt(1, maSp);
    	    	           pstmt1.setString(2, tenSp);
    	    	           pstmt1.setString(3, size);
    	    	           pstmt1.setInt(4, soLuong);
    	    	           pstmt1.setString(5, giaBan);
    	    	           pstmt1.executeUpdate();
    	    	       } catch (SQLException e1) {
    		    	         e1.printStackTrace();
    		    	         }	                 
    		            }catch (NumberFormatException ex) { 	
    	                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Sản Phẩm.");
    	                    }
    		    	    clearTextFields();    		    	    	        
    		    }

    		    private void saveImageToDatabase(String imagePath, int maSp) {
    		        try {
    		            File imageFile = new File(imagePath);
    		            FileInputStream fis = new FileInputStream(imageFile);

    		            String url = "jdbc:mysql://localhost:3306/QL_CHQA";
    		            String user = "root";
    		            String password = "haily0910";
    		            String sql = "UPDATE QuanLySanPham SET anh = ? WHERE maSp = ?";

    		            try (Connection connection = DriverManager.getConnection(url, user, password);
    		                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
    		                pstmt.setBinaryStream(1, fis, (int) imageFile.length());
    		                pstmt.setInt(2, maSp);
    		                pstmt.executeUpdate();

    		                JOptionPane.showMessageDialog(null, "Lưu ảnh vào cơ sở dữ liệu thành công!");
    		            } catch (SQLException ex) {
    		                ex.printStackTrace();
    		                JOptionPane.showMessageDialog(null, "Lỗi khi lưu ảnh vào cơ sở dữ liệu!");
    		            }
    		        } catch (FileNotFoundException ex) {
    		            ex.printStackTrace();
    		            JOptionPane.showMessageDialog(null, "Không tìm thấy tệp ảnh!");
    		        }
    		    }
    		    private void clearTextFields() {
    		        txtMasp.setText("");
    		        txtchatlieu.setText("");
    		        txtTen.setText("");
    		        txtsz.setSelectedItem("");
    		        txtSoluong.setText("");
    		        txtGianhap.setText("");
    		        txtGiaban.setText("");
    		        a.setIcon(null);
    		    }
    		});

	     btnXoa2.addActionListener(new ActionListener() {	
	    	 @Override
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Sanpham sp = new Sanpham();
				 sp.setMaSp(Integer.parseInt(txtMasp.getText()));
				 DBConnection.xoa2(sp);
				 showData(DBConnection.findAll2());
				 clearTextFields();
				}
	    	 private void clearTextFields() {
	        	 txtMasp.setText("");	       
	             txtchatlieu.setText("");
	             txtTen.setText("");
	             txtsz.setSelectedItem("");
	             txtSoluong.setText("");
	             txtGianhap.setText("");
	             txtGiaban.setText("");
	             a.setIcon(null);	             
	             }
	    	 });
	     btnSua2.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {
	    	        try {
	    	            Sanpham sp = new Sanpham();
	    	            sp.setMaSp(Integer.parseInt(txtMasp.getText()));
	    	            sp.setChatLieu(txtchatlieu.getText());
	    	            sp.setTenSp(txtTen.getText());
	    	            sp.setSize(txtsz.getSelectedItem().toString());
	    	            sp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
	    	            sp.setGiaNhap(txtGianhap.getText());
	    	            sp.setGiaBan(txtGiaban.getText());
	    	            sp.setAnh(imagePath);

	    	            String url = "jdbc:mysql://localhost:3306/QL_CHQA";
	    	            String user = "root";
	    	            String password = "haily0910";
	    	            String query = "UPDATE QL_CHQA.QuanLySanPham SET Chatlieu=?, tenSp=?, Size=?, soLuong=?, giaNhap=?, giaBan=?, anh=? WHERE maSp=?";
	    	            String query1 = "UPDATE QL_CHQA.QuanLySanPham1 SET  tenSp=?, Size=?, soLuong=?, giaBan=? WHERE maSp=?";

	    	            try (Connection connection = DriverManager.getConnection(url, user, password);
	    	                 PreparedStatement pstmt = connection.prepareStatement(query)) {
	    	                pstmt.setString(1, sp.getChatLieu());
	    	                pstmt.setString(2, sp.getTenSp());
	    	                pstmt.setString(3, sp.getSize());
	    	                pstmt.setInt(4, sp.getSoLuong());
	    	                pstmt.setString(5, sp.getGiaNhap());
	    	                pstmt.setString(6, sp.getGiaBan());
	    	                pstmt.setString(7, sp.getAnh());
	    	                pstmt.setInt(8, sp.getMaSp());

	    	                pstmt.executeUpdate();
	    	                JOptionPane.showMessageDialog(null, "Sửa thành công!");
	    	                showData(DBConnection.findAll2());
	    	            } 
	    	            catch (SQLException ex) {
	    	                ex.printStackTrace();
	    	            }
	    	            try (Connection connection = DriverManager.getConnection(url, user, password);
		    	                 PreparedStatement pstmt1 = connection.prepareStatement(query1)) {
		    	                pstmt1.setString(1, sp.getTenSp());
		    	                pstmt1.setString(2, sp.getSize());
		    	                pstmt1.setInt(3, sp.getSoLuong());
		    	                pstmt1.setString(4, sp.getGiaBan());
		    	                pstmt1.setInt(5, sp.getMaSp());
		    	                pstmt1.executeUpdate();
		    	            } 
		    	            catch (SQLException ex) {
		    	                ex.printStackTrace();
		    	            }
	    	            
	    	            clearTextFields();
	    	        } catch (NumberFormatException ex) {
	    	            JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Sản Phẩm.");
	    	        }
	    	    }

	    	    private void clearTextFields() {
	    	        txtMasp.setText("");
	    	        txtchatlieu.setText("");
	    	        txtTen.setText("");
	    	        txtsz.setSelectedItem("");
	    	        txtSoluong.setText("");
	    	        txtGianhap.setText("");
	    	        txtGiaban.setText("");
	    	        a.setIcon(null);
	    	    }
	    	}); 	
	     tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {		   
	    	 public void valueChanged(ListSelectionEvent event) {		        
	    		 if (!event.getValueIsAdjusting()) {		            
	    			 int selectedRow = tbl.getSelectedRow();		            
	    			 if (selectedRow != -1) {
	    				 
	    				 txtMasp.setText(tbl.getValueAt(selectedRow, 0).toString());
	                     txtchatlieu.setText(tbl.getValueAt(selectedRow, 1).toString());
	                     txtTen.setText(tbl.getValueAt(selectedRow, 2).toString());
	                     String size = tbl.getValueAt(selectedRow, 3).toString();
	                     txtsz.setSelectedItem(size); 
	                     txtSoluong.setText(tbl.getValueAt(selectedRow, 4).toString());
	                     txtGianhap.setText(tbl.getValueAt(selectedRow, 5).toString());
	                     txtGiaban.setText(tbl.getValueAt(selectedRow, 6).toString());
	                     String anh = tbl.getValueAt(selectedRow, 7).toString();
	                     displayImage2(anh);
	                     imagePath = anh; 	 
	    				
	    			 }	    			 
	    		 }		  
	    	 }		   
	     });    
	     tbl.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 2) {
	               	 clearTextFields();
	                }               
	            }
	            private void clearTextFields() {
	            	txtMasp.setText("");
	    	        txtchatlieu.setText("");
	    	        txtTen.setText("");
	    	        txtsz.setSelectedItem("");
	    	        txtSoluong.setText("");
	    	        txtGianhap.setText("");
	    	        txtGiaban.setText("");
	    	        a.setIcon(null);
	        	}
	            
	        });
	     btntimkiem.addActionListener(new ActionListener() {       
	    	 @Override
	          public void actionPerformed(ActionEvent e) {
	    		 // TODO Auto-generated method stub
			     Sanpham sp = new Sanpham();
			     sp.setMaSp(Integer.parseInt(txttimkiem.getText()));
			     showData(DBConnection.timkiem2(sp));
			     ql2.setVisible(true);
			     ql2.addActionListener(new ActionListener() {
			    	 @Override
			    	 public void actionPerformed(ActionEvent e) {
			    		 // TODO Auto-generated method stub
					     txttimkiem.setText("");
					     ql2.setVisible(false);
					     showData(DBConnection.findAll2());					    
			    	 }			    	
			     });				   
	    	 }	              
	     });
	     btntimkiem2.addActionListener(new ActionListener() {       
	    	 @Override
	          public void actionPerformed(ActionEvent e) {
	    		 // TODO Auto-generated method stub
			     Sanpham sp = new Sanpham();
			     sp.setTenSp(txttimkiem2.getText());
			     showData(DBConnection.timkiem22(sp));
			     ql2.setVisible(true);
			     ql2.addActionListener(new ActionListener() {
			    	 @Override
			    	 public void actionPerformed(ActionEvent e) {
			    		 // TODO Auto-generated method stub
					     txttimkiem2.setText("");
					     ql2.setVisible(false);
					     showData(DBConnection.findAll2());					    
			    	 }			    	
			     });				   
	    	 }	              
	     });
	     out.addActionListener(new ActionListener() {
	 	    @Override
	 	    public void actionPerformed(ActionEvent e) {
	 	    	new Dangnhap(); 
	 	    	dispose();
	 	    }
	 	});
	     quanlynhanvien.addActionListener(new ActionListener() {
	    	    @Override
	    	    public void actionPerformed(ActionEvent e) {	    	    	
	    	    	new QLNV();
	      	        dispose();
	    	    }
	    	});

	     quanlydonhang.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Laphoadon();
	                dispose();
	            }
	        });
	     quanlydangnhap.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new Quanly();

	            }
	        });
	     thongke.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                new QLTK();
	                dispose();
	            }
	        });

	     setLocationRelativeTo(null);
	     setVisible(true);
	}
	private void displayImage2(String imagePath2) {
		if (imagePath2 != null && !imagePath2.isEmpty()) {
	    ImageIcon originalIcon = new ImageIcon(imagePath2);
	    Image originalImage = originalIcon.getImage();
	    Image resizedImage = originalImage.getScaledInstance(150, 160, Image.SCALE_SMOOTH);
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);
	    a.setIcon(resizedIcon);
		} else {
	      a.setIcon(null);
	    }
	}
	public void showData(List<Sanpham> sanpham) {
		List<Sanpham>Lsp = new ArrayList<>();
    	Lsp=sanpham;
    	DefaultTableModel spmodel;
    	tbl.getModel();
    	spmodel = (DefaultTableModel)tbl.getModel();
    	spmodel.setRowCount(0);
	    Lsp.forEach(sp -> {
	        spmodel.addRow(new Object[]{
	                sp.getMaSp(), sp.getChatLieu(), sp.getTenSp(), sp.getSize(),sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(),sp.getAnh()
	        });
	    });	    
	}	
	 public static void main(String[] args) {
	    	QLSP sp = new QLSP();
	    	sp.setLocationRelativeTo(null);
			sp.setVisible(true);    	
	 }
}

