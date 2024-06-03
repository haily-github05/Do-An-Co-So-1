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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import Dto.Taikhoan;

public class QLDN extends JFrame{
	private static JTable tbl4 = new JTable();
	public QLDN() {
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
	    Quanly.tk(txttk);
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
        
        
	    JPanel panelquanlydangnhap = new JPanel();
	    panelquanlydangnhap.setBackground(Color.pink);
	    panelquanlydangnhap.setPreferredSize(new Dimension(1200,765));
	    panel.add(panelquanlydangnhap);
	    
	    JLabel jLabel_4= new JLabel("Quản Lý Đăng Nhập",JLabel.CENTER);
		Font font4 = new Font("Serif",Font.CENTER_BASELINE,50);
		jLabel_4.setFont(font4);
	    jLabel_4.setBackground(Color.pink);
	    jLabel_4.setOpaque(true);
	    panelquanlydangnhap.add(jLabel_4,BorderLayout.NORTH);
	    
	    JPanel pn5 = new JPanel();	    
	    pn5.setBackground(Color.pink);
  	    pn5.setPreferredSize(new Dimension(1200,150));  
	    panelquanlydangnhap.add(pn5);
	    
		    
	    JPanel pn51 = new JPanel (new GridLayout(4,2));
		pn51.setBackground(Color.pink);
		pn51.setPreferredSize(new Dimension(600,140));
		pn5.add(pn51);

	    JLabel lblsdt4 = new JLabel("    SĐT:");
	    JTextField txtsdt4 = new JTextField();
	    JLabel lbltaikhoan = new JLabel("    Tài khoản:");
	    JTextField txttaikhoan = new JTextField();
	    JLabel lblmatkhau = new JLabel("    Mật khẩu:");
	    JTextField txtmatkhau= new JTextField();
	    JLabel lblchucvu4 = new JLabel("    Chức vụ:");
	    JTextField txtchucvu4 = new JTextField();
	    pn51.add(lblsdt4);
	    pn51.add(txtsdt4);
	    pn51.add(lbltaikhoan);
	    pn51.add(txttaikhoan);
	    pn51.add(lblmatkhau);
	    pn51.add(txtmatkhau);
	    pn51.add(lblchucvu4);
	    pn51.add(txtchucvu4);
	    
	    JPanel pn52= new JPanel(); 
	    pn52.setBackground(Color.pink);
	    pn52.setPreferredSize(new Dimension(1200,550));
	    panelquanlydangnhap.add(pn52,BorderLayout.SOUTH);

	    JButton btnThem4 = new JButton("Thêm");
	    JButton btnXoa4 = new JButton("Xóa");
	    JButton btnSua4 = new JButton("Sửa");
	    pn52.add(btnThem4);
	    pn52.add(btnXoa4);  
	    pn52.add(btnSua4);

	    DefaultTableModel dm4=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	    };
	    dm4.addColumn("SĐT");
	    dm4.addColumn("Tài khoản");
	    dm4.addColumn("Mật khẩu");
	    dm4.addColumn("Chức vụ");
	    tbl4 = new JTable(dm4);	
	    JScrollPane sc4=new JScrollPane(tbl4);
	    sc4.setPreferredSize(new Dimension(1190,390));
	    pn52.add(sc4,BorderLayout.SOUTH);		
	    showData(DBConnection.findAll4()); 
	    
	    JPanel pn4= new JPanel();
    	pn4.setBackground(Color.pink);
    	pn4.setPreferredSize(new Dimension(1200,110));
    	pn52.add(pn4);
		JPanel pn4b= new JPanel();
    	pn4b.setBackground(Color.pink);
        pn4b.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem4 = new JButton("Tìm kiếm theo Tên");
    	JTextField txttimkiem4= new JTextField(20);
    	pn4.add(pn4b);
        pn4.add(txttimkiem4);
    	pn4.add(btntimkiem4); 
    	JPanel pn4c= new JPanel();
    	pn4c.setBackground(Color.pink);
        pn4c.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem44 = new JButton("Tìm kiếm theo Sdt");
    	JTextField txttimkiem44= new JTextField(20);
    	pn4.add(pn4c);
        pn4.add(txttimkiem44);
    	pn4.add(btntimkiem44); 
    	JButton ql = new JButton("Quay lại");        
    	pn4.add(ql);
    	ql.setVisible(false);
    	
    	txtsdt4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txttaikhoan.requestFocus();
			}
		});
    	txttaikhoan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtmatkhau.requestFocus();
			}
		});
    	txtmatkhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtchucvu4.requestFocus();
			}
		});
	    btnThem4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	    	    try {	    	    		                
	                String sdt = txtsdt4.getText();        
	                String ten = txttaikhoan.getText();
	                String mk  = txtmatkhau.getText();
	                String chucvu = txtchucvu4.getText();
         
	                DefaultTableModel model = (DefaultTableModel) tbl4.getModel();
	                model.addRow(new Object[]{sdt,ten,mk,chucvu});

	                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
	                String user ="root";
	    	        String password= "haily0910";
	    	        String sqlThem4 = "INSERT INTO QL_CHQA.DangNhap (sdt,taikhoan,matkhau,chucvu) VALUES (?,?,?,?)";
	    	       try {
	    	    	   Connection connection = DriverManager.getConnection(url, user, password);	    	     
	    	           PreparedStatement pstmt = connection.prepareStatement(sqlThem4);
	    	           pstmt.setString(1, sdt);
	    	           pstmt.setString(2,ten);
	    	           pstmt.setString(3, mk);
	    	           pstmt.setString(4, chucvu);
	    	           pstmt.executeUpdate();
	    	       } catch (SQLException e1) {
	    	         e1.printStackTrace();
	    	         }	                 
	            }catch (NumberFormatException ex) { 	
                 JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng.");
                 }
	    	    clearTextFields();
	    	    }	        
	        private void clearTextFields() {
	        	 txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");
	        }
	        });
	     btnXoa4.addActionListener(new ActionListener() {	
	    	 @Override
			 public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 Taikhoan tk = new Taikhoan();
				 tk.setSdt(txtsdt4.getText());
				 DBConnection.xoa4(tk);
				 showData(DBConnection.findAll4());
				 clearTextFields();
				}
	    	 private void clearTextFields() {
	        	 txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");  
	             }
	    	 });
	     btnSua4.addActionListener(new ActionListener() {
	    	 @Override
	    	 public void actionPerformed(ActionEvent e) {
	    		 Taikhoan tk= new Taikhoan();
	    	     tk.setSdt(txtsdt4.getText());
	    	     tk.setTen(txttaikhoan.getText());
	    	     tk.setMk(txtmatkhau.getText());
	             tk.setChucvu(txtchucvu4.getText());
	        
	             String url = "jdbc:mysql://localhost:3306/QL_CHQA";
	             String user = "root"; 
	             String password = "haily0910";
	             String query = "UPDATE QL_CHQA.DangNhap SET Taikhoan=?,Matkhau=?, Chucvu=? WHERE Sdt=? ";      
	             try (Connection connection = DriverManager.getConnection(url, user, password);
	            		 PreparedStatement pstmt = connection.prepareStatement(query)) { 	 
	            	 pstmt.setString(1, tk.getTen());
	                 pstmt.setString(2, tk.getMk());
	                 pstmt.setString(3, tk.getChucvu());
	                 pstmt.setString(4, tk.getSdt());               
	                 pstmt.executeUpdate();
	                 JOptionPane.showMessageDialog(null,"Sửa thành công!");
			         showData(DBConnection.findAll4());
			         } catch (SQLException ex) {
			        	 ex.printStackTrace();	        
			         } 	       
	             clearTextFields(); 	   
	    	 } 	   
	    	 private void clearTextFields() {
	        	 txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");  
	             }
	    	 });

	        btntimkiem4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Taikhoan tk = new Taikhoan();
					tk.setTen(txttimkiem4.getText());
					showData(DBConnection.timkiem4(tk));
					ql.setVisible(true);
					ql.addActionListener(new ActionListener() {
						@Override				
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							txttimkiem4.setText("");
							ql.setVisible(false);
							showData(DBConnection.findAll4());
						}
					});	
				}
	        });
	        btntimkiem44.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Taikhoan tk = new Taikhoan();
					tk.setSdt(txttimkiem44.getText());
					showData(DBConnection.timkiem44(tk));
					ql.setVisible(true);
					ql.addActionListener(new ActionListener() {
						@Override				
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							txttimkiem44.setText("");
							ql.setVisible(false);
							showData(DBConnection.findAll4());
						}
					});	
				}
	        });
	    tbl4.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
 	    public void valueChanged(ListSelectionEvent event) {
 	        if (!event.getValueIsAdjusting()) {
 	            int selectedRow = tbl4.getSelectedRow();
 	            if (selectedRow != -1) {
 	                Object sdt = tbl4.getValueAt(selectedRow, 0);
 	                Object ten = tbl4.getValueAt(selectedRow, 1);
 	                Object mk = tbl4.getValueAt(selectedRow, 2);
 	                Object chucvu = tbl4.getValueAt(selectedRow, 3);
 	                
 	                txtsdt4.setText(sdt.toString());
 	                txttaikhoan.setText(ten.toString());
 	                txtmatkhau.setText(mk.toString());
 	                txtchucvu4.setText(chucvu.toString());
 	              
 	            }
 	        }
 	    }
 	});
	    tbl4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
               	 clearTextFields();
                }               
            }
            private void clearTextFields() {
            	txtsdt4.setText("");	       
	             txttaikhoan.setText("");
	             txtmatkhau.setText("");
	             txtchucvu4.setText("");  
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
     quanlydonhang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Laphoadon();
                dispose();
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
	public void showData(List<Taikhoan> tk) {
		List<Taikhoan>Ltk = new ArrayList<>();
    	Ltk=tk;
    	DefaultTableModel tkmodel;
    	tbl4.getModel();
    	tkmodel = (DefaultTableModel)tbl4.getModel();
    	tkmodel.setRowCount(0);
	    Ltk.forEach(tk1 -> {
	        tkmodel.addRow(new Object[]{
	                tk1.getSdt(), tk1.getTen(), tk1.getMk(),tk1.getChucvu()
	        });
	    });
	}
	public static void main(String[] args) {
    	QLDN dn = new QLDN();
    	dn.setLocationRelativeTo(null);
	    dn.setVisible(true);    	
    }
}
