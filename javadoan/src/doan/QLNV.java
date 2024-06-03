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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Dto.Nhanvien;


public class QLNV extends JFrame {
	private static JTable tbl = new JTable();
	private JLabel a;
	private String imagePath;
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public QLNV() {		
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

        
        JPanel panelquanlynhanvien = new JPanel();
        panelquanlynhanvien.setBackground(Color.pink);
        panelquanlynhanvien.setPreferredSize(new Dimension(1200,765));
        panel.add(panelquanlynhanvien);
		JLabel jLabel_1= new JLabel("Quản Lý Nhân Viên",JLabel.CENTER);
		Font font = new Font("Serif",Font.CENTER_BASELINE,50);
		jLabel_1.setFont(font);
	    jLabel_1.setBackground(Color.pink);
	    jLabel_1.setOpaque(true);		
		panelquanlynhanvien.add(jLabel_1,BorderLayout.NORTH);

		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.pink);
		pn1.setPreferredSize(new Dimension(1200,180));
		panelquanlynhanvien.add(pn1);
		
		JPanel pn11 = new JPanel (new GridLayout(4,8));
		pn11.setBackground(Color.pink);
		pn11.setPreferredSize(new Dimension(1060,140));
		pn1.add(pn11,BorderLayout.WEST);
		
		JPanel pn12 = new JPanel();
		pn12.setBackground(Color.pink);
		pn12.setPreferredSize(new Dimension(120,170));
		pn1.add(pn12);
		a =new JLabel(" ");
		a.setPreferredSize(new Dimension(120,160));
	    pn12.add(a);	 
		JLabel lblManv = new JLabel("    Mã nhân viên:");
		JTextField txtManv = new JTextField();
		JLabel lblTennv = new JLabel("    Tên nhân viên:");
		JTextField txtTennv= new JTextField();
		JLabel sdt = new JLabel("    SĐT");
		JTextField txtsdt= new JTextField();
		JLabel lblgt = new JLabel("    Giới tính:");
		JComboBox<String> txtgt = new JComboBox<>(new String[]{"","Nam", "Nữ"});
		JLabel lblNgaylv = new JLabel("    Ngày vào làm việc:");
		JDateChooser txtNgaylv = new JDateChooser();
		txtNgaylv.setDateFormatString("dd-MM-yyyy");
		txtNgaylv.getJCalendar().setPreferredSize(new Dimension(350, 200));
		txtNgaylv.setBackground(Color.pink);
		JLabel lblNgaysinh = new JLabel("    Ngày sinh:");
		JDateChooser txtNgaysinh = new JDateChooser();
		txtNgaysinh.setDateFormatString("dd-MM-yyyy");
		txtNgaysinh.getJCalendar().setPreferredSize(new Dimension(350, 200));
		txtNgaysinh.setBackground(Color.pink);
		JLabel lblchucvu = new JLabel("    Chức vụ:");
		JComboBox<String> txtchucvu = new JComboBox<>(new String[]{"","Tiếp thị", "Thu ngân","Chăm sóc khác hàng","Quản lý","Trưởng ca","Mẫu ảnh","Livestream"});
		JButton btnChonAnh = new JButton("Chọn ảnh");
  	    btnChonAnh.setPreferredSize(new Dimension(150, 20));	
		pn11.add(lblManv);
		pn11.add(txtManv);
		pn11.add(lblTennv);
		pn11.add(txtTennv);
		pn11.add(sdt);
		pn11.add(txtsdt);
		pn11.add(lblgt);
		pn11.add(txtgt);
		pn11.add(lblNgaylv);
		pn11.add(txtNgaylv);
		pn11.add(lblNgaysinh);
		pn11.add(txtNgaysinh);
		pn11.add(lblchucvu);
		pn11.add(txtchucvu);		
        pn11.add(btnChonAnh);

		
    	JPanel pn1a= new JPanel();
    	pn1a.setBackground(Color.pink);
        pn1a.setPreferredSize(new Dimension(1200,500));
        panelquanlynhanvien.add(pn1a,BorderLayout.SOUTH);
  	
        JButton btnThem = new JButton("Thêm");
    	JButton btnXoa = new JButton("Xóa");
    	JButton btnSua = new JButton("Sửa");
    	pn1a.add(btnThem);
    	pn1a.add(btnXoa);
    	pn1a.add(btnSua);

    	DefaultTableModel dm=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	    };
    	dm.addColumn("Mã nhân viên");
    	dm.addColumn("Tên nhân viên");
    	dm.addColumn("SĐT");
    	dm.addColumn("Giới tính");
    	dm.addColumn("Ngày vào làm việc");
    	dm.addColumn("Ngày sinh");
    	dm.addColumn("Chức vụ");
    	dm.addColumn("Ảnh"); 
    	tbl =new JTable(dm);
    	JScrollPane sc=new JScrollPane(tbl);
    	sc.setPreferredSize(new Dimension(1190,355));
    	showData(DBConnection.findAll());   	
        pn1a.add(sc,BorderLayout.SOUTH); 
		sc.setViewportView(tbl);
        
        JPanel pn1b= new JPanel();
    	pn1b.setBackground(Color.pink);
        pn1b.setPreferredSize(new Dimension(700,5));
        JButton btntimkiem = new JButton("Tìm kiếm theo Mã");
    	JTextField txttimkiem= new JTextField(20);
    	pn1a.add(pn1b);
        pn1a.add(txttimkiem);
    	pn1a.add(btntimkiem); 
    	JPanel pn1c= new JPanel();
    	pn1c.setBackground(Color.pink);
        pn1c.setPreferredSize(new Dimension(705,5));
        JButton btntimkiem2 = new JButton("Tìm kiếm theo Tên");
    	JTextField txttimkiem2= new JTextField(20);
    	pn1a.add(pn1c);
        pn1a.add(txttimkiem2);
    	pn1a.add(btntimkiem2); 
    	JButton ql = new JButton("Quay lại");        
    	pn1a.add(ql);
    	ql.setVisible(false);
    	
    	txtManv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTennv.requestFocus();
			}
		});
    	txtTennv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtsdt.requestFocus();
			}
		});
    	txtsdt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtgt.requestFocus();
			}
		});
    	txtgt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtNgaylv.requestFocus();
			}
		});    	
//chuc nang cac nut   	
    	btnChonAnh.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 JFileChooser fileChooser = new JFileChooser();
                 int result = fileChooser.showOpenDialog(QLNV.this);
                 if (result == JFileChooser.APPROVE_OPTION) {
                     File selectedFile = fileChooser.getSelectedFile();
                     imagePath = selectedFile.getAbsolutePath();
                     displayImage(imagePath);
                 }
             }
         });
        btnThem.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {    	    	
    	    	try {
    	        int manv = Integer.parseInt(txtManv.getText());
    	        String tennv = txtTennv.getText();
    	        int sdt= Integer.parseInt(txtsdt.getText());
    	        String gioitinh = txtgt.getSelectedItem().toString();   	        
    	        java.sql.Date ngayvaolv = new java.sql.Date(txtNgaylv.getDate().getTime());
    	        java.sql.Date ngaysinh = new java.sql.Date(txtNgaysinh.getDate().getTime());
    	        String chucvu = txtchucvu.getSelectedItem().toString();
    	        String anh = imagePath;

    	        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
    	        model.addRow(new Object[]{manv, tennv,sdt,gioitinh, ngayvaolv, ngaysinh, chucvu,anh});
        	     
    	        saveImageToDatabase(imagePath, manv);
    	         String url ="jdbc:mysql://localhost:3306/QL_CHQA";
    	         String user ="root";
    	    	 String password= "haily0910";	    
    	    	 String sqlThem = "INSERT INTO QL_CHQA.QuanLyNhanVien (manv, tennv, sdt, gioitinh, ngayvaolv, ngaysinh, chucvu, anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    	    	 try (Connection connection = DriverManager.getConnection(url, user, password);
    	    	      PreparedStatement pstmt = connection.prepareStatement(sqlThem)) {
    	    	     pstmt.setInt(1, manv);
    	    	     pstmt.setString(2, tennv);
    	    	     pstmt.setInt(3, sdt);
    	    	     pstmt.setString(4, gioitinh);
    	    	     pstmt.setDate(5,  ngayvaolv);
    	             pstmt.setDate(6,  ngaysinh);
    	    	     pstmt.setString(7, chucvu);
    	    	     pstmt.setString(8, anh);
    	    	     pstmt.executeUpdate();
    	    	     int rowsAffected = pstmt.executeUpdate();
    	             if (rowsAffected > 0) {
    	                 JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!");
    	                 showData(DBConnection.findAll());
    	             }
    	    	   } catch (SQLException ex) {
    	               ex.printStackTrace();
    	               JOptionPane.showMessageDialog(null, "Lỗi khi thêm nhân viên!");
    	           }
    	    }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Nhân Viên.");
            }
    	    	clearTextFields();
        }
    	    private void saveImageToDatabase(String imagePath, int manv) {
		        try {
		            File imageFile = new File(imagePath);
		            FileInputStream fis = new FileInputStream(imageFile);

		            String url = "jdbc:mysql://localhost:3306/QL_CHQA";
		            String user = "root";
		            String password = "haily0910";
		            String sql = "UPDATE QuanLyNhanVien SET anh = ? WHERE manv = ?";

		            try (Connection connection = DriverManager.getConnection(url, user, password);
		                 PreparedStatement pstmt = connection.prepareStatement(sql)) {
		                pstmt.setBinaryStream(1, fis, (int) imageFile.length());
		                pstmt.setInt(2, manv);
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
    	        txtManv.setText("");
    	        txtTennv.setText("");
    	        txtsdt.setText("");
    	        txtgt.setSelectedItem("");
    	        txtNgaylv.setDate(null);
    	        txtNgaysinh.setDate(null); 
    	        txtchucvu.setSelectedItem("");
    	        a.setIcon(null);
    	    }
    	});
        btnXoa.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		// TODO Auto-generated method stub        		
        		  try {
                      int manv = Integer.parseInt(txtManv.getText());
                      Nhanvien nv = new Nhanvien();
                      nv.setManv(manv);
                      DBConnection.xoa1(nv);
                      showData(DBConnection.findAll());
                      clearTextFields();
                  } catch (NumberFormatException ex) {
                      JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã Nhân Viên để xóa.");
                  }
			}
        	private void clearTextFields() {
        	    txtManv.setText("");
        	    txtTennv.setText("");
        	    txtsdt.setText("");
        	    txtgt.setSelectedItem("");
        	    txtNgaylv.setDate(null);
        	    txtNgaysinh.setDate(null); 
        	    txtchucvu.setSelectedItem("");
        	    a.setIcon(null);
        	}
		});  
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRow = tbl.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để sửa!");
                        return;
                    }
                    int manv = Integer.parseInt(txtManv.getText());
                    String tennv = txtTennv.getText();
                    int sdt = Integer.parseInt(txtsdt.getText());
                    String gioitinh = txtgt.getSelectedItem().toString();
                    String ngayvaolv = sdf.format(txtNgaylv.getDate());
                    String ngaysinh = sdf.format(txtNgaysinh.getDate());
                    String chucvu = txtchucvu.getSelectedItem().toString();
                    String anh = imagePath;

                    Nhanvien nv = new Nhanvien();
                    nv.setManv(manv);
                    nv.setTennv(tennv);
                    nv.setSdt(sdt);
                    nv.setGioitinh(gioitinh);
                    nv.setNgayvaolv(ngayvaolv);
                    nv.setNgaysinh(ngaysinh);
                    nv.setChucvu(chucvu);
                    nv.setAnh(anh);

                    String url = "jdbc:mysql://localhost:3306/QL_CHQA";
                    String user = "root";
                    String password = "haily0910";
                    String query = "UPDATE QuanLyNhanVien SET tennv=?, sdt=?, gioitinh=?, ngayvaolv=?, ngaysinh=?, chucvu=?, anh=? WHERE manv=?";
                    try (Connection connection = DriverManager.getConnection(url, user, password);
                         PreparedStatement pstmt = connection.prepareStatement(query)) {
                        pstmt.setString(1, nv.getTennv());
                        pstmt.setInt(2, nv.getSdt());
                        pstmt.setString(3, nv.getGioitinh());
                        pstmt.setString(4, nv.getNgayvaolv());
                        pstmt.setString(5, nv.getNgaysinh());
                        pstmt.setString(6, nv.getChucvu());
                        pstmt.setString(7, nv.getAnh());
                        pstmt.setInt(8, nv.getManv());

                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Sửa thành công!");
                            showData(DBConnection.findAll());
                        } else {
                            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên để sửa!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Lỗi khi thực hiện câu lệnh sửa!");
                    }
                    clearTextFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng định dạng cho Mã Nhân Viên hoặc SĐT.");
                }
            }
            private void clearTextFields() {
        	    txtManv.setText("");
        	    txtTennv.setText("");
        	    txtsdt.setText("");
        	    txtgt.setSelectedItem("");
        	    txtNgaylv.setDate(null);
        	    txtNgaysinh.setDate(null); 
        	    txtchucvu.setSelectedItem("");
        	    a.setIcon(null);
        	}
            
        });        
    	tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tbl.getSelectedRow();
                    if (selectedRow != -1) {
                        txtManv.setText(tbl.getValueAt(selectedRow, 0).toString());
                        txtTennv.setText(tbl.getValueAt(selectedRow, 1).toString());
                        txtsdt.setText(tbl.getValueAt(selectedRow, 2).toString()); 
                        String gioitinh = tbl.getValueAt(selectedRow, 3).toString();
                        txtgt.setSelectedItem(gioitinh); 
                        String chucvu = tbl.getValueAt(selectedRow, 6).toString();
                        txtchucvu.setSelectedItem(chucvu); 
                        String anh = tbl.getValueAt(selectedRow, 7).toString();
                        displayImage(anh);
                        imagePath = anh; 
                        try {
                            java.util.Date date = sdf.parse(tbl.getValueAt(selectedRow, 4).toString());
                            txtNgaylv.setDate(date);                        
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }  try {                         
                            java.util.Date date2 = sdf.parse(tbl.getValueAt(selectedRow, 5).toString());
                            txtNgaysinh.setDate(date2);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                        }
                                             
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
        	    txtManv.setText("");
        	    txtTennv.setText("");
        	    txtsdt.setText("");
        	    txtgt.setSelectedItem("");
        	    txtNgaylv.setDate(null);
        	    txtNgaysinh.setDate(null); 
        	    txtchucvu.setSelectedItem("");
        	    a.setIcon(null);
        	}           
        });
        btntimkiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Nhanvien nv = new Nhanvien();
				nv.setManv(Integer.parseInt(txttimkiem.getText()));
				showData(DBConnection.timkiem(nv));
				ql.setVisible(true);
				ql.addActionListener(new ActionListener() {
					@Override				
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txttimkiem.setText("");
						ql.setVisible(false);
						showData(DBConnection.findAll());
					}
				});	
			}
        });
        btntimkiem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Nhanvien nv = new Nhanvien();
				nv.setTennv(txttimkiem2.getText());
				showData(DBConnection.timkiem1(nv));
				ql.setVisible(true);
				ql.addActionListener(new ActionListener() {
					@Override				
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txttimkiem2.setText("");
						ql.setVisible(false);
						showData(DBConnection.findAll());
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
	private void displayImage(String imagePath) {
	    if (imagePath != null && !imagePath.isEmpty()) {
	        ImageIcon originalIcon = new ImageIcon(imagePath);
	        Image originalImage = originalIcon.getImage();
	        Image resizedImage = originalImage.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        a.setIcon(resizedIcon);
	    } else {
	        a.setIcon(null);
	    }
	}
	public void showData(List<Nhanvien> nhanViens) {
		List<Nhanvien>Lnv = new ArrayList<>();
    	Lnv=nhanViens;
    	DefaultTableModel nvmodel;
    	tbl.getModel();
    	nvmodel = (DefaultTableModel)tbl.getModel();
    	nvmodel.setRowCount(0);
    	for (Nhanvien nv : nhanViens) {
    	        nvmodel.addRow(new Object[]{
    	            nv.getManv(), nv.getTennv(), nv.getSdt(), nv.getGioitinh(),nv.getNgayvaolv(), nv.getNgaysinh(), nv.getChucvu(), nv.getAnh()
    	        });
    	    }	    
	}
	 public static void main(String[] args) {
	    	QLNV nv1 = new QLNV();
	    	nv1.setLocationRelativeTo(null);
			nv1.setVisible(true);    	
	    }

}
