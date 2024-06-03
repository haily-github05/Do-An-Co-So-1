package doan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Quanly extends JFrame {
    private JButton jButton_DangNhap;
    private Container container;
    private static JTextField UsernameField;

    public Quanly() {
        setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = getContentPane();
        JPanel pn = new JPanel();
        pn.setBackground(Color.pink);

        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(450, 300));
        pn2.setBackground(Color.pink);
        pn.add(pn2);
        JLabel jLabel_DangNhap = new JLabel("Quản lý", JLabel.CENTER);
        Font font = new Font("Arial", Font.CENTER_BASELINE, 50);
        jLabel_DangNhap.setFont(font);
        jLabel_DangNhap.setBackground(Color.pink);
        jLabel_DangNhap.setOpaque(true);
        pn2.add(jLabel_DangNhap);

        JPanel pn2a = new JPanel();
        pn2a.setPreferredSize(new Dimension(300, 40));
        pn2a.setLayout(new GridLayout(1, 1));
        pn2a.setBackground(Color.pink);

        JPanel pn2b = new JPanel();
        pn2b.setPreferredSize(new Dimension(440, 150));
        pn2b.setBackground(Color.pink);
        pn2b.setVisible(true);
        pn2.add(pn2b);
        pn2.add(pn2a, BorderLayout.SOUTH);
        getContentPane().setLayout(new FlowLayout());
        pn2b.setLayout(new GridLayout(3, 2));
        pn2b.add(new JLabel("  Tên Đăng Nhập :"));
        UsernameField = new JTextField();
        pn2b.add(UsernameField);
        pn2b.add(new JLabel("  Mật Khẩu :"));
        JPasswordField PasswordField = new JPasswordField();
        pn2b.add(PasswordField);
        JCheckBox checkBox = new JCheckBox("Hiển thị mật khẩu");
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
        JButton thoat = new JButton("Thoát");
        pn2a.add(thoat);
        jButton_DangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = UsernameField.getText();
                String password = new String(PasswordField.getPassword());
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
                    return;
                }
                String url = "jdbc:mysql://localhost:3306/QL_CHQA";
                String user = "root";
                String password1 = "haily0910";
                try (Connection connection = DriverManager.getConnection(url, user, password1)) {
                    String sql = "SELECT * FROM DangNhap WHERE Matkhau = '12345'";
                    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                        try (ResultSet resultSet = pstmt.executeQuery()) {
                            if (resultSet.next()) {
                                new QLDN();
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
        thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	thoat();
            }
        });
        PasswordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton_DangNhap.doClick();
            }
        });
        UsernameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordField.requestFocus();
            }
        });

        this.setLayout(new BorderLayout());
        this.add(pn, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Quanly::new);
    }
    private void thoat() {
        this.dispose();
    }
    public static  JTextField tk(JTextField x) {
		String s = UsernameField.getText();
		x.setText(s);
		return x;		
	}
}
