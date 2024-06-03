package doan;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Dto.Hoadon;
import Dto.Sanpham;

public class QLTK extends JFrame {
    private JTable tbl = new JTable();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private Connection connection;
    private JTextField a21, a41, a61; 
    private JSpinner a11, a31, a51;   
    
    public QLTK() {
        setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY");
        setSize(1400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        Container container = getContentPane();

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setPreferredSize(new Dimension(190, 765));
        panel.add(panel1);
        // add Ảnh
        ImageIcon anh = new ImageIcon("///Users/hohaily/eclipse-workspace/java1/src/picture/Logo.png");
        Image scaledImage = anh.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        anh = new ImageIcon(scaledImage);
        JLabel panel11 = new JLabel(anh, JLabel.RIGHT);
        panel11.setIcon(anh);
        panel1.add(panel11);

        JPanel panel12 = new JPanel();
        panel12.setBackground(Color.pink);
        panel12.setPreferredSize(new Dimension(190, 500));
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


        JPanel pn = new JPanel();
        pn.setBackground(Color.pink);
        pn.setPreferredSize(new Dimension(1200, 765));
        panel.add(pn);

        JLabel jLabel_1 = new JLabel("Thống kê doanh số", JLabel.CENTER);
        Font font = new Font("Serif", Font.CENTER_BASELINE, 50);
        jLabel_1.setFont(font);
        jLabel_1.setBackground(Color.pink);
        jLabel_1.setOpaque(true);
        pn.add(jLabel_1, BorderLayout.NORTH);

        JPanel pn1 = new JPanel();
        pn1.setPreferredSize(new Dimension(1200, 330));
        pn1.setBackground(Color.pink);
        pn.add(pn1);

        Font font1 = new Font("Arial", Font.CENTER_BASELINE, 20);

        JPanel pn11 = new JPanel(new GridLayout(3, 2));
        pn11.setPreferredSize(new Dimension(600, 100));
        pn11.setBackground(Color.pink);
        pn1.add(pn11);
        JLabel a1 = new JLabel("  Doanh thu ngày :");
        a1.setFont(font1);
        JDateChooser a12 = new JDateChooser();
        a12.setDateFormatString("dd-MM-yyyy");
        a12.getJCalendar().setPreferredSize(new Dimension(350, 200)); 
        a12.setBackground(Color.pink); 
        JLabel a2 = new JLabel("  Tổng doanh thu:");
        a21 = new JTextField();
        a21.setEditable(false); 
        JLabel a22 = new JLabel();
        JButton a23 = new JButton("Tính tổng"); 
        pn11.add(a1);
        pn11.add(a12); 
        pn11.add(a2);
        pn11.add(a21);
        pn11.add(a22);
        pn11.add(a23);


        JPanel pn12 = new JPanel(new GridLayout(3, 2));
        pn12.setPreferredSize(new Dimension(600, 100));
        pn12.setBackground(Color.pink);
        pn1.add(pn12);
        JLabel a3 = new JLabel("  Doanh thu tháng :");
        a3.setFont(font1);
        SpinnerDateModel model3 = new SpinnerDateModel();
        a31 = new JSpinner(model3);
        JSpinner.DateEditor editor3 = new JSpinner.DateEditor(a31, "MM-yyyy");
        a31.setEditor(editor3);
        JLabel a4 = new JLabel("  Tổng doanh thu:");
        a41 = new JTextField();
        a41.setEditable(false); 
        JLabel a42 = new JLabel();        
        JButton a43 = new JButton("Tính tổng");
        pn12.add(a3);
        pn12.add(a31);
        pn12.add(a4);
        pn12.add(a41);
        pn12.add(a42);
        pn12.add(a43);

        JPanel pn13 = new JPanel(new GridLayout(3, 2));
        pn13.setPreferredSize(new Dimension(600, 100));
        pn13.setBackground(Color.pink);
        pn1.add(pn13);
        JLabel a5 = new JLabel("  Doanh thu năm :");
        a5.setFont(font1);
        SpinnerDateModel model5 = new SpinnerDateModel();
        a51 = new JSpinner(model5);
        JSpinner.DateEditor editor5 = new JSpinner.DateEditor(a51, "yyyy");
        a51.setEditor(editor5);
        JLabel a6 = new JLabel("  Tổng doanh thu:");
        a61 = new JTextField();
        a61.setEditable(false); 
        JLabel a62 = new JLabel();
        JButton a63 = new JButton("Tính tổng");
        pn13.add(a5);
        pn13.add(a51);
        pn13.add(a6);
        pn13.add(a61);
        pn13.add(a62);
        pn13.add(a63);
        
        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(1200, 360));
        pn2.setBackground(Color.pink);
        pn.add(pn2);
        
        DefaultTableModel dm=new DefaultTableModel(){
	    	 @Override
	    	 public boolean isCellEditable(int row, int column) {
	    		 return false;
	    	 }
	    };
        dm.addColumn("Mã hoá đơn");
        dm.addColumn("Ngày bán");
        dm.addColumn("Tổng tiền");
        tbl =new JTable(dm);
    	JScrollPane sc=new JScrollPane(tbl);
    	sc.setPreferredSize(new Dimension(1190,300));
    	pn2.add(sc,BorderLayout.SOUTH);
    	showData(DBConnection.findAll333());
    	JButton ql2 = new JButton("Quay lại");
    	ql2.setVisible(false);   	
    	pn2.add(ql2);
    	a23.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        Hoadon hd = new Hoadon();
    	        String ngayban = sdf.format(a12.getDate());
    	        hd.setNgayban(ngayban);
    	        List<Hoadon> dsHoadon = DBConnection.timkiem333(hd);
    	        showData(dsHoadon);
    	        double tongTien = 0;
    	        for (Hoadon hoadon : dsHoadon) {
    	            tongTien += hoadon.getTongtien();
    	        }
    	        a21.setText(String.valueOf(tongTien));
    	        ql2.setVisible(true);
    	        ql2.addActionListener(new ActionListener() {
			    	 @Override
			    	 public void actionPerformed(ActionEvent e) {
			    		 // TODO Auto-generated method stub
					     a12.setDate(null);
					     a21.setText("");
					     ql2.setVisible(false);
					     showData(DBConnection.findAll333());					    
			    	 }			    	
			     });				   
    	    }
    	});
    	a43.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        Date date = (Date) a31.getValue();
    	        SimpleDateFormat month = new SimpleDateFormat("MM");
    	        SimpleDateFormat year = new SimpleDateFormat("yyyy");
    	        
    	        String month1 = month.format(date);
    	        String year1 = year.format(date);
    	        
    	        List<Hoadon> dsHoadon = DBConnection.findAll333();
    	        List<Hoadon> filteredHoadon = new ArrayList<>();
    	        
    	        for (Hoadon hoadon : dsHoadon) {
    	            String[] dateParts = hoadon.getNgayban().split("-");
    	            String invoiceMonth = dateParts[1];
    	            String invoiceYear = dateParts[2];    	            
    	            if (month1.equals(invoiceMonth) && year1.equals(invoiceYear)) {
    	                filteredHoadon.add(hoadon);
    	            }
    	        }
    	        showData(filteredHoadon);
    	        double tongTien = 0;
    	        for (Hoadon hoadon : filteredHoadon) {
    	            tongTien += hoadon.getTongtien();
    	        }
    	        a41.setText(String.valueOf(tongTien));
    	        ql2.setVisible(true);   	        
    	        ql2.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                a31.setValue(new Date());
    	                a41.setText("");
    	                ql2.setVisible(false);
    	                showData(DBConnection.findAll333());
    	            }
    	        });
    	    }
    	});
    	a63.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        Date date = (Date) a51.getValue();
    	        SimpleDateFormat year = new SimpleDateFormat("yyyy");
    	        
    	        String year1 = year.format(date);
    	        
    	        List<Hoadon> dsHoadon = DBConnection.findAll333();
    	        List<Hoadon> filteredHoadon = new ArrayList<>();
    	        
    	        for (Hoadon hoadon : dsHoadon) {
    	            String[] dateParts = hoadon.getNgayban().split("-");
    	            String invoiceYear = dateParts[2];
    	            
    	            if ( year1.equals(invoiceYear)) {
    	                filteredHoadon.add(hoadon);
    	            }
    	        }	        
    	        showData(filteredHoadon);  	        
    	        double tongTien = 0;
    	        for (Hoadon hoadon : filteredHoadon) {
    	            tongTien += hoadon.getTongtien();
    	        }    	        
    	        a61.setText(String.valueOf(tongTien));
    	        ql2.setVisible(true);        
    	        ql2.addActionListener(new ActionListener() {
    	            @Override
    	            public void actionPerformed(ActionEvent e) {
    	                a51.setValue(new Date());
    	                a61.setText("");
    	                ql2.setVisible(false);
    	                showData(DBConnection.findAll333());
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
    public void showData(List<Hoadon> hd) {
		List<Hoadon>Lhd = new ArrayList<>();
    	Lhd=hd;
    	DefaultTableModel spmodel;
    	tbl.getModel();
    	spmodel = (DefaultTableModel)tbl.getModel();
    	spmodel.setRowCount(0);
	    Lhd.forEach(hd1 -> {
	        spmodel.addRow(new Object[]{
	                hd1.getMahd(), hd1.getNgayban(), hd1.getTongtien()
	        });
	    });	    
	}	
    public static void main(String[] args) {
        QLTK tk = new QLTK();
        tk.setLocationRelativeTo(null);
        tk.setVisible(true);
    }
}
