package doan;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Dto.Taikhoan;

public class Dangnhap extends JFrame{
	private JButton jButton_DangNhap;
	private Container container;
	private static JTextField UsernameField;
	public Dangnhap() { 
		setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY" );
		setSize(750, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = getContentPane();
		JPanel pn =new JPanel();
		pn.setBackground(Color.pink);
		
		JPanel pn1 = new JPanel();
		pn.setPreferredSize(new Dimension(300,330));
		pn1.setBackground(Color.pink);
		pn.add(pn1);
		
		ImageIcon anh = new ImageIcon("///Users/hohaily/eclipse-workspace/java1/src/picture/Logo.png");
	    Image scaledImage = anh.getImage().getScaledInstance(280, 290, Image.SCALE_SMOOTH);
	    anh= new ImageIcon(scaledImage);
	    JLabel panel1a = new JLabel(anh,JLabel.RIGHT);	    
	    panel1a.setIcon(anh);      
	    pn1.add(panel1a);
	
	    JPanel pn2 = new JPanel();
		pn2.setPreferredSize(new Dimension(450,300));
		pn2.setBackground(Color.pink);
		pn.add(pn2);		
		JLabel jLabel_DangNhap= new JLabel("Đăng Nhập",JLabel.CENTER);
		Font font = new Font("Arial",Font.CENTER_BASELINE,50);
		jLabel_DangNhap.setFont(font);
		jLabel_DangNhap.setBackground(Color.pink);
	    jLabel_DangNhap.setOpaque(true);
	    pn2.add(jLabel_DangNhap);
	    
	    JPanel pn2a = new JPanel();
		pn2a.setPreferredSize(new Dimension(300,50));
		pn2a.setLayout(new GridLayout(1,1));
		pn2a.setBackground(Color.pink);
		
	    JPanel pn2b = new JPanel();
		pn2b.setPreferredSize(new Dimension(450,150));
		pn2b.setBackground(Color.pink);
		pn2b.setVisible(true);
		pn2.add(pn2b);
        pn2.add(pn2a,BorderLayout.SOUTH);
		getContentPane().setLayout(new FlowLayout());
		pn2b.setLayout(new GridLayout(3,2));
		pn2b.add(new JLabel("  Tên Đăng Nhập :"));
	    UsernameField = new JTextField();
	    pn2b.add(UsernameField);
	    pn2b.add(new JLabel("  Mật Khẩu :"));
	    JPasswordField PasswordField = new JPasswordField();
	    pn2b.add(PasswordField);
	    JLabel quenmk =new JLabel("  Quên mật khẩu");
	    pn2b.add(quenmk);
	    JCheckBox checkBox =new JCheckBox("Hiển thị mật khẩu");
	    pn2b.add(checkBox);
	    checkBox.addActionListener(new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					PasswordField.setEchoChar('\0');					
	                } else {
	                    PasswordField.setEchoChar('*');
	                }	
			}
		});		 
	   	jButton_DangNhap = new JButton("Đăng Nhập");
	    pn2a.add(jButton_DangNhap);
		jButton_DangNhap.addActionListener((ActionListener) new ActionListener() {
			private Component frame;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = UsernameField.getText();
                String password = new String(PasswordField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                    return;
                } 
                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
  	            String user ="root";
  	    	    String password1= "haily0910";
  	    	  try (Connection connection = DriverManager.getConnection(url, user, password1)) {
                  String sql = "SELECT * FROM DangNhap WHERE Taikhoan = ? AND Matkhau = ?";
                  try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                      pstmt.setString(1, username);
                      pstmt.setString(2, password);

                      try (ResultSet resultSet = pstmt.executeQuery()) {
                          if (resultSet.next()) {
                        	  new QLSP();
                        	   dispose();
                          } else {
                              JOptionPane.showMessageDialog(null, "Đăng nhập thất bại!");
                          }
                      }
                  }
              } catch (SQLException ex) {
                  ex.printStackTrace();
              }
          }
		});
		PasswordField.addActionListener(new ActionListener() {				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jButton_DangNhap.doClick();
			}
		});
		UsernameField.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PasswordField.requestFocus();
			}
		});
	    JPanel pn2c = new JPanel();
		pn2c.setPreferredSize(new Dimension(450,150));
		pn2c.setLayout(new GridLayout(4,2));
		pn2c.setBackground(Color.pink);
		pn2.add(pn2c);
		pn2c.setVisible(false);
		JLabel lblsdt = new JLabel("Số điện thoại:");
		JTextField txtsdt = new JTextField();
	    JLabel lblten = new JLabel("Tên đăng nhập:");
	    JTextField txtten = new JTextField();
		JLabel lblmk = new JLabel("Mật khẩu mới:");
		JPasswordField mk = new JPasswordField();
		JLabel lblmk1 = new JLabel("Nhập lại mật khẩu:");
		JPasswordField mk1 = new JPasswordField();
		pn2c.add(lblsdt);
		pn2c.add(txtsdt);
		pn2c.add(lblten);
		pn2c.add(txtten);
		pn2c.add(lblmk);
		pn2c.add(mk);
		pn2c.add(lblmk1);
		pn2c.add(mk1);
		JPanel pn2d = new JPanel();
		pn2d.setPreferredSize(new Dimension(300,50));
		pn2d.setLayout(new GridLayout(1,1));
		pn2d.setBackground(Color.pink);
		pn2.add(pn2d);
		pn2d.setVisible(false);
		JButton jButton_xacnhan = new JButton("Xác nhận");
	    pn2d.add(jButton_xacnhan);
	    JButton jButton_ql= new JButton("Quay lại");
	    pn2d.add(jButton_ql);
	    txtsdt.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtten.requestFocus();
			}
		});
	    txtten.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mk.requestFocus();
			}
		});
	    mk.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mk1.requestFocus();
			}
		});	   
		jButton_xacnhan.addActionListener((ActionListener) new ActionListener() {
			private Component frame;
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Auto-generated method stub
				Taikhoan tk = new Taikhoan();
				tk.setMk(new String(mk.getPassword()));
	            tk.setSdt(txtsdt.getText());
	            tk.setTen(txtten.getText());
	            if (tk.getMk().isEmpty() || new String(mk1.getPassword()).isEmpty() || tk.getTen().isEmpty() || tk.getSdt().isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
	                return;
	            }
	            if (!tk.getMk().equals(new String(mk1.getPassword()))) {
	                JOptionPane.showMessageDialog(null, "Mật khẩu và Nhập lại mật khẩu không khớp!");
	                clearTextFields();
	                return;
	            }
                String url ="jdbc:mysql://localhost:3306/QL_CHQA";
  	            String user ="root";
  	    	    String password1= "haily0910";
  	    	    try (Connection connection = DriverManager.getConnection(url, user, password1)) {
  	    	    	String checkExistSql = "SELECT * FROM DangNhap WHERE sdt = ?";
  	    	    	try (PreparedStatement checkExistStmt = connection.prepareStatement(checkExistSql)) {
  	    	    		checkExistStmt.setString(1, tk.getSdt()); 	    	        
  	    	    		try (ResultSet existResultSet = checkExistStmt.executeQuery()) {
  	    	    			if (existResultSet.next()) {  	    	 	    	            	
  	    	    				String updatePasswordSql = "UPDATE DangNhap SET  taikhoan = ?, Matkhau = ? WHERE sdt = ?";
  	    	    				try (
  	    	    						PreparedStatement updatePasswordStmt = connection.prepareStatement(updatePasswordSql)) {
  	    	    					updatePasswordStmt.setString(1, tk.getTen());
  	    	    					updatePasswordStmt.setString(2, tk.getMk());
  	    	    					updatePasswordStmt.setString(3, tk.getSdt());
  	    	    					updatePasswordStmt.executeUpdate();  	    	                    
  	    	    					JOptionPane.showMessageDialog(null, "Mật khẩu đã được thay đổi!");   	                    
  	    	    					pn2c.setVisible(false);
  	    	    					pn2d.setVisible(false);
  	    	    					pn2b.setVisible(true);
  	    	    					pn2a.setVisible(true);
  	    	    				}
  	    	    			} else {
  	    	                JOptionPane.showMessageDialog(null, "Số điện thoại không tồn tại!");
  	    	    			}
  	    	    		} 	    	        
  	    	    	}
  	    	    } catch (SQLException ex) {
  	    	    ex.printStackTrace();
  	    	    System.out.println("1111");
  	    	}
  	    	clearTextFields();
			}			
			private void clearTextFields() {
	    	        txtsdt.setText("");
	    	        txtten.setText("");
	    	        mk.setText("");
	    	        mk1.setText("");
			}
		}); 
		mk1.addActionListener((ActionEvent e) -> {		
			// TODO Auto-generated method stub
            jButton_xacnhan.doClick();
		});
		jButton_ql.addActionListener(e -> {
            if (!pn2a.isVisible()) {
            	pn2a.setVisible(true);
                pn2b.setVisible(true);
                pn2c.setVisible(false);
                pn2d.setVisible(false);
            }
        });   
		quenmk.addMouseListener((MouseListener) new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	            if (!pn2c.isVisible()) {
	            	pn2d.setVisible(true);
	                pn2c.setVisible(true);
	                pn2b.setVisible(false);
	                pn2a.setVisible(false);
	            }
	    	}	  
		}); 		
		this.setLayout(new BorderLayout());
		this.add(pn,BorderLayout.CENTER);	
		setLocationRelativeTo(null);
		setVisible(true);
	}	
	public static  JTextField tk(JTextField x) {
		String s = UsernameField.getText();
		x.setText(s);
		return x;		
	}
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(Dangnhap::new);
	    }
}