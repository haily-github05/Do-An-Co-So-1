package doan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Dto.Donhang;
import Dto.Sanpham1;
import TextFile.File1;


public class Laphoadon extends JFrame {
	private static JTable tbl = new JTable();
	private static JTable tbl3 = new JTable();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private Connection connection;
	
	public Laphoadon() {
		setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY" );
		setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel,BorderLayout.CENTER);
        Container container = getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setPreferredSize(new Dimension(190,760));;
        panel.add(panel1,BorderLayout.WEST);      
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

        
        JPanel panelquanlydonhang = new JPanel(); 
        panelquanlydonhang.setBackground(Color.pink);
        panelquanlydonhang.setPreferredSize(new Dimension(1195,760));
        panel.add(panelquanlydonhang,BorderLayout.EAST);
        
        JPanel pn = new JPanel();
	    pn.setBackground(Color.pink);
	    pn.setPreferredSize(new Dimension(1000,70));  	    
	    panelquanlydonhang.add(pn,BorderLayout.NORTH);
	    
        JLabel jLabel_3= new JLabel("Lập Hoá Đơn",JLabel.CENTER);
	    Font font3 = new Font("Serif",Font.CENTER_BASELINE,50);
	    jLabel_3.setFont(font3);
	    jLabel_3.setBackground(Color.pink);
        jLabel_3.setOpaque(true); 
	    pn.add(jLabel_3);
	    
   
	     JPanel pn1 = new JPanel();
	     pn1.setBackground(Color.white);
    	 pn1.setPreferredSize(new Dimension(1180,670));  
	     panelquanlydonhang.add(pn1);
//	     
	     JPanel pn1a = new JPanel();
	     pn1a.setBackground(Color.pink);
     	 pn1a.setPreferredSize(new Dimension(400,660));  
	     pn1.add(pn1a);
	     
	     JButton btntimkiem = new JButton("Tìm kiếm theo Mã ");
	     JTextField txttimkiem= new JTextField(15);
	     pn1a.add(txttimkiem);
	     pn1a.add(btntimkiem);
	    	
	     JButton btntimkiem2 = new JButton("Tìm kiếm theo Tên");
	     JTextField txttimkiem2= new JTextField(15);
	     pn1a.add(txttimkiem2);
	     pn1a.add(btntimkiem2);
	     JButton ql2 = new JButton("Quay lại");
	     ql2.setVisible(false);   	
	     pn1a.add(ql2);
	     DefaultTableModel dm=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	     };
		 dm.addColumn("Mã sản phẩm");
		 dm.addColumn("Tên sản phẩm");
		 dm.addColumn("Size");
		 dm.addColumn("Số lượng");
		 dm.addColumn("Giá bán");
		 tbl =new JTable(dm);
		 JScrollPane sc1=new JScrollPane(tbl);
		 sc1.setPreferredSize(new Dimension(390,355));
		 pn1a.add(sc1,BorderLayout.SOUTH);
		 showData(doan.DBConnection.findAll22());	
		 
		 btntimkiem.addActionListener(new ActionListener() {       
		   	 @Override
		   	 public void actionPerformed(ActionEvent e) {
		   		 // TODO Auto-generated method stub
		   		 Sanpham1 sp = new Sanpham1();
				 sp.setMasp(Integer.parseInt(txttimkiem.getText()));
				 showData(doan.DBConnection.timkiem2a(sp));
				 ql2.setVisible(true);
				 ql2.addActionListener(new ActionListener() {
					 @Override
					 public void actionPerformed(ActionEvent e) {
						 // TODO Auto-generated method stub
						 txttimkiem.setText("");
						 ql2.setVisible(false);
						 showData(doan.DBConnection.findAll22());					    
					 }			    	
				 });				   
		   	 }	              
		 });
		 btntimkiem2.addActionListener(new ActionListener() {       
		  		@Override
		  		public void actionPerformed(ActionEvent e) {
		   		 // TODO Auto-generated method stub
				     Sanpham1 sp = new Sanpham1();
				     sp.setTensp(txttimkiem2.getText());
				     showData(doan.DBConnection.timkiem22a(sp));
				     ql2.setVisible(true);
				     ql2.addActionListener(new ActionListener() {
				    	 @Override
				    	 public void actionPerformed(ActionEvent e) {
				    		 // TODO Auto-generated method stub
						     txttimkiem2.setText("");
						     ql2.setVisible(false);
						     showData(doan.DBConnection.findAll22());					    
				    	 }			    	
				     });				   
		   	 }	              
		 });
		 tbl.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 1) {
	                    int selectedRow = tbl.getSelectedRow();
	                    if (selectedRow != -1) {
	                        String productId = tbl.getValueAt(selectedRow, 0).toString();
	                        String productName = tbl.getValueAt(selectedRow, 1).toString();
	                        double price = Double.parseDouble(tbl.getValueAt(selectedRow, 4).toString());

	                        Hoadon.AddToTableCallback callback = new Hoadon.AddToTableCallback() {
	                            @Override
	                            public void addToTable(String productId, String productName, int quantity, double price, String notes) {
	                                DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
	                                double totalPrice = quantity * price;
	                                model.addRow(new Object[]{model.getRowCount() + 1, productId, productName, quantity, price, totalPrice, notes});
	                            }
	                        };
	                        new Hoadon(productId, productName, price, callback).setVisible(true);
	                    }
	                }
	            }
	        });
//     
	     JPanel pn1b = new JPanel();
	     pn1b.setBackground(Color.pink);
     	 pn1b.setPreferredSize(new Dimension(770,660));  
	     pn1.add(pn1b);
	     	
	     JPanel pn3 = new JPanel(new GridLayout(2,4));
	     pn3.setBackground(Color.pink);
     	 pn3.setPreferredSize(new Dimension(760,70));  
	     pn1b.add(pn3);
	     
	     JLabel lblMahd = new JLabel("    Mã hoá đơn:");
	     JTextField txtMahd = new JTextField();
	     txtMahd.setText(generateNewMahd()); 
	     JLabel lblNgayban = new JLabel("    Ngày bán:");
	     JDateChooser txtNgayban = new JDateChooser();
	     txtNgayban.setDateFormatString("dd-MM-yyyy");
	     txtNgayban.getJCalendar().setPreferredSize(new Dimension(350, 200));
	     txtNgayban.setBackground(Color.pink);
	     JLabel lblManv3 = new JLabel("    Mã nhân viên:");
	     JTextField txtManv3 = new JTextField();
	     JLabel lblghichu = new JLabel("    Ghi chú:");
	     JTextField txtghichu = new JTextField();
	     JButton xoa = new JButton("Xoá");
	     xoa.setVisible(false);
	     JButton sua = new JButton("Sửa");
	     sua.setVisible(false);
	     pn3.add(lblMahd); 
	     pn3.add(txtMahd);
	     pn3.add(lblNgayban);
	     pn3.add(txtNgayban);     	     
	     pn3.add(lblManv3);
	     pn3.add(txtManv3);
	     pn3.add(lblghichu);
	     pn3.add(txtghichu);
	     	     
	     txtManv3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					txtghichu.requestFocus();
				}
			});
	     
	    JPanel pn4= new JPanel();
	    pn4.setBackground(Color.pink);
        pn4.setPreferredSize(new Dimension(760,570));
        pn1b.add(pn4);
        pn4.add(xoa);
        pn4.add(sua);
        
	    DefaultTableModel dm2=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	    };
	    dm2.addColumn("STT");
	    dm2.addColumn("Mã sản phẩm");
	    dm2.addColumn("Tên sản phẩm");
	    dm2.addColumn("Số lượng");
	    dm2.addColumn("Đơn giá");    
	    dm2.addColumn("Thành tiền");
	    dm2.addColumn("Ghi chú");
	    tbl3 =new JTable(dm2);	
	    JScrollPane sc=new JScrollPane(tbl3);
	    sc.setPreferredSize(new Dimension(740,320));
	    showData3(doan.DBConnection.findAll33());
	    pn4.add(sc);
	        
	    JPanel pn5 = new JPanel();
	    pn5.setPreferredSize(new Dimension(740,210));	
	    pn5.setBackground(Color.pink);
	    pn4.add(pn5);
	   
	    JPanel pn6 = new JPanel(new GridLayout(4,3));
	    pn6.setPreferredSize(new Dimension(740,140));
	    pn6.setBackground(Color.pink);
	    pn5.add(pn6);   
	    JLabel lbgiamgia= new JLabel("    Giảm giá(%):");
	    JTextField txtgiamgia = new JTextField();
	    JLabel tick= new JLabel();	
	    ImageIcon anh1 = new ImageIcon("///Users/hohaily/eclipse-workspace/java1/src/picture/tick.jpeg");
	    Image scaledImage1 = anh1.getImage().getScaledInstance(27, 27, Image.SCALE_SMOOTH);
	    anh1 = new ImageIcon(scaledImage1);
	    tick.setIcon(anh1);   
	    JLabel lbltong = new JLabel("    Tổng:");
	    JTextField txttong = new JTextField();
	    JLabel trong= new JLabel();	
	 	JLabel lbltra= new JLabel("    Khách trả:");
	 	JTextField txttra = new JTextField();
	 	JLabel tick1= new JLabel();
	 	tick1.setIcon(anh1);   
	 	JLabel lbldu = new JLabel("    Khách dư:");	
	 	JTextField txtdu = new JTextField();
	 	pn6.add(lbgiamgia);
	 	pn6.add(txtgiamgia);
	 	pn6.add(tick);
	 	pn6.add(lbltong);
	 	pn6.add(txttong);
	 	pn6.add(trong);
	 	pn6.add(lbltra);
	 	pn6.add(txttra);
	 	pn6.add(tick1);
	 	pn6.add(lbldu);
	 	pn6.add(txtdu);
	   
	 	xoa.addActionListener(new ActionListener() {
	 		@Override
	 		public void actionPerformed(ActionEvent e) {
	 			int selectedRow = tbl3.getSelectedRow();
	 			if (selectedRow != -1) {
	 				DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
	 				model.removeRow(selectedRow);
	 				xoa.setVisible(false);
	 				sua.setVisible(false);
	 				for(int i =0; i< model.getRowCount();i++) {
	 					model.setValueAt(i+1, i, 0);
	 				}
	 			} else {
	 				JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để xoá", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	 			}
	 		}
	 	});
	 	sua.addActionListener(new ActionListener() {
	 		@Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = tbl3.getSelectedRow();
		        if (selectedRow != -1) {
		            String productId = tbl3.getValueAt(selectedRow, 1).toString();
		            String productName = tbl3.getValueAt(selectedRow, 2).toString();
		            double price = Double.parseDouble(tbl3.getValueAt(selectedRow, 4).toString());
		            updateSelectedRow(selectedRow, productId, productName, selectedRow, price, productName);
		            Hoadon.AddToTableCallback callback = new Hoadon.AddToTableCallback() {
		                @Override
		                public void addToTable(String productId, String productName, int quantity, double price, String notes) {
		                    DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
		                    double totalPrice = quantity * price;
		                    model.addRow(new Object[]{model.getRowCount() + 1, productId, productName, quantity, price, totalPrice, notes});
		                }
		            };
		            new Hoadon(productId, productName, price, callback).setVisible(true);
		            xoa.setVisible(false);
	                sua.setVisible(false);
		        }
		    }	 		
	 	});
	 	tick.addMouseListener(new MouseAdapter() {
	 		@Override
	 		public void mouseClicked(MouseEvent e) {
	 			try {
	 				double tongtien = 0;
	 				for (int i = 0; i < tbl3.getRowCount(); i++) {
	 					tongtien += Double.parseDouble(tbl3.getValueAt(i, 5).toString());
	 				}
	 				txttong.setText(String.valueOf(tongtien));
	 				double giamgia = Double.parseDouble(txtgiamgia.getText());
	 				double thanhtoan = tongtien * (1 - giamgia / 100);
	 				txttong.setText(String.valueOf(thanhtoan));
	 			} catch (NumberFormatException ex) {
	 			}
	 		}
	 	});
	   tick1.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {          
                   double tong = Double.parseDouble(txttong.getText());
                   double tra1 = Double.parseDouble(txttra.getText());
                   double tra = tra1-tong;
                   txtdu.setText(String.valueOf(tra));
           }
       });
	   tbl3.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               if (e.getClickCount() == 1) {
                  xoa.setVisible(true);
                  sua.setVisible(true);
               }
               if (e.getClickCount() == 2) {
                   xoa.setVisible(false);
                   sua.setVisible(false);
                }
           }
       });	  
	   JPanel pn7 = new JPanel();
	   pn7.setPreferredSize(new Dimension(740,50));
	   pn7.setBackground(Color.pink);
	   pn5.add(pn7);
	   JButton bt1 = new JButton("Tạo hoá đơn mới");
	   bt1.setPreferredSize(new Dimension(150,40));
	   JButton bt2 = new JButton("Xem danh sách hoá đơn");
	   bt2.setPreferredSize(new Dimension(200,40));
	   JLabel trong1= new JLabel();
	   trong1.setPreferredSize(new Dimension(170,40));
	   JButton bt3 = new JButton("Lưu");
	   bt3.setPreferredSize(new Dimension(150,40));
	   pn7.add(bt1);
	   pn7.add(bt2);
	   pn7.add(trong1);
	   pn7.add(bt3);
	   
	   bt1.addActionListener(new ActionListener() {
       		@Override
       		public void actionPerformed(ActionEvent e) {
       			// TODO Auto-generated method stub 
       			DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
       			model.setRowCount(0);
       			txtMahd.setText(generateNewMahd());
       			txtManv3.setText("");
       			txtghichu.setText("");      	   
       			txtNgayban.setDate(null);
       			txtgiamgia.setText("");  
       			txttong.setText("");    
       			txttra.setText("");    
       			txtdu.setText("");         
       		}
		});  
	   bt2.addActionListener(new ActionListener() {
      		@Override
      		public void actionPerformed(ActionEvent e) {
      			// TODO Auto-generated method stub 
      			new DSHoadon();
      		}
		});
	   bt3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (tbl3.getRowCount() == 0) {
		            JOptionPane.showMessageDialog(rootPane, "Bảng trống không thể xuất file");
		        } else {
		            String mahd = txtMahd.getText();
		            String ngayban = new SimpleDateFormat("dd-MM-yyyy").format(txtNgayban.getDate());
		            String filePath = "hoadon_"+mahd+" ngày "+ngayban+".txt";
		            try {
		                File1.writeInvoiceToFile1(mahd, ngayban, Integer.parseInt(txtManv3.getText()), txtghichu.getText(), txtgiamgia.getText(), txttong.getText(), txttra.getText(), txtdu.getText(), filePath, tbl3);
		                System.out.println("Xuất file thành công.");
		                JOptionPane.showMessageDialog(null, "Lưu thành công hoá đơn_"+mahd+" ngày "+ngayban+".txt");
		                for (int i = 0; i < tbl3.getRowCount(); i++) {
		                    int maSp = Integer.parseInt(tbl3.getValueAt(i, 1).toString());
		                    int soLuongBanRa = Integer.parseInt(tbl3.getValueAt(i, 3).toString());
		                    updateSoLuongTonKho(maSp, soLuongBanRa);
		                }
		                String tong= txttong.getText();
		                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
    	                String user ="root";
    	    	        String password= "haily0910";
    	    	        String sqlThem = "INSERT INTO QL_CHQA.Laphoadon (mahd,ngayban,tongtien) VALUES (?,?,?)";   	    	
    	    	       try {
    	    	    	   Connection connection = DriverManager.getConnection(url, user, password);	    	     
    	    	           PreparedStatement pstmt = connection.prepareStatement(sqlThem);
    	    	           pstmt.setString(1, mahd);
    	    	           pstmt.setString(2, ngayban);
    	    	           pstmt.setString(3, tong);
    	    	           pstmt.executeUpdate();
    	    	       } catch (SQLException e1) {
    		    	         e1.printStackTrace();
    		    	         }	                    		            
		                DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
		                model.setRowCount(0);
		                txtMahd.setText(generateNewMahd());
		           	    txtManv3.setText("");
		           	    txtghichu.setText("");      	   
		           	    txtNgayban.setDate(null);
		           	    txtgiamgia.setText("");  
		           	    txttong.setText("");    
		           	    txttra.setText("");    
		           	    txtdu.setText("");  
		            } catch (Exception ex) {
		            	JOptionPane.showInputDialog("Xuất file không thành công.");
		                ex.printStackTrace();		                
		            }
		        }
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

	quanlysanpham.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new QLSP();
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
	public void updateSelectedRow(int selectedRow, String productId, String productName, int quantity, double price, String notes) {
        DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
        model.removeRow(selectedRow);
        for(int i =0; i< model.getRowCount();i++) {
        model.setValueAt(i+1, i, 0);
        }
	}

	public void showData3(List<Donhang> donhang1) {
		List<Donhang>Ldh1 = new ArrayList<>();
    	Ldh1=donhang1;
    	DefaultTableModel dh1model;
    	tbl3.getModel();
    	dh1model = (DefaultTableModel)tbl3.getModel();
    	dh1model.setRowCount(0);
	    Ldh1.forEach(dh1 -> {
	        dh1model.addRow(new Object[]{
	                dh1.getStt(),dh1.getMasp(), dh1.getTensp(), dh1.getSoluong(),dh1.getDongia(), dh1.getThanhtien()	                 
	        });
	    });
	} 
	private void updateSoLuongTonKho(int maSp, int soLuongBanRa) {
	    String url = "jdbc:mysql://localhost:3306/QL_CHQA";
	    String user = "root";
	    String password = "haily0910";
	    String sqlLaySoLuongTonKho1 = "SELECT soLuong FROM QuanLySanPham WHERE maSp = ?";
	    String sqlCapNhatTonKho1 = "UPDATE QuanLySanPham SET soLuong = ? WHERE maSp = ?";
	    String sqlLaySoLuongTonKho2 = "SELECT soLuong FROM QuanLySanPham1 WHERE maSp = ?";
	    String sqlCapNhatTonKho2 = "UPDATE QuanLySanPham1 SET soLuong = ? WHERE maSp = ?";
	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             PreparedStatement pstmtLaySoLuong1 = connection.prepareStatement(sqlLaySoLuongTonKho1);
	             PreparedStatement pstmtCapNhat1 = connection.prepareStatement(sqlCapNhatTonKho1);
	             PreparedStatement pstmtLaySoLuong2 = connection.prepareStatement(sqlLaySoLuongTonKho2);
	             PreparedStatement pstmtCapNhat2 = connection.prepareStatement(sqlCapNhatTonKho2)) {

	            connection.setAutoCommit(false);
	            pstmtLaySoLuong1.setInt(1, maSp);
	            ResultSet rs1 = pstmtLaySoLuong1.executeQuery();
	            if (rs1.next()) {
	                int soLuong1 = rs1.getInt("soLuong");
	                int soLuongMoi1 = soLuong1 - soLuongBanRa;
	                pstmtCapNhat1.setInt(1, soLuongMoi1);
	                pstmtCapNhat1.setInt(2, maSp);
	                pstmtCapNhat1.executeUpdate();
	            }
	            pstmtLaySoLuong2.setInt(1, maSp);
	            ResultSet rs2 = pstmtLaySoLuong2.executeQuery();
	            if (rs2.next()) {
	                int soLuong2 = rs2.getInt("soLuong");
	                int soLuongMoi2 = soLuong2 - soLuongBanRa;
	                pstmtCapNhat2.setInt(1, soLuongMoi2);
	                pstmtCapNhat2.setInt(2, maSp);
	                pstmtCapNhat2.executeUpdate();
	            }
	            connection.commit();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            try {	             
	                connection.rollback();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	public void showData(List<Sanpham1> sanpham) {
		List<Sanpham1>Lsp = new ArrayList<>();
    	Lsp=sanpham;
    	DefaultTableModel spmodel;
    	tbl.getModel();
    	spmodel = (DefaultTableModel)tbl.getModel();
    	spmodel.setRowCount(0);
	    Lsp.forEach(sp -> {
	        spmodel.addRow(new Object[]{
	                sp.getMasp(), sp.getTensp(), sp.getSize(),sp.getSoluong(), sp.getGiaban()
	        });
	    });	    
	}	
	private String generateNewMahd() {
	    String newMahd = "HD0001"; 
	    try {
	        connection = DBConnection.getConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement("SELECT mahd FROM Laphoadon ORDER BY mahd DESC LIMIT 1");
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            String lastMahd = resultSet.getString("mahd");
	            int num = Integer.parseInt(lastMahd.substring(2)) + 1;
	            newMahd = String.format("HD%04d", num); 
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return newMahd;
	}
	 public static void main(String[] args) {
	    	Laphoadon dh1 = new Laphoadon();
	    	dh1.setLocationRelativeTo(null);
			dh1.setVisible(true);    	
	    }
	}
