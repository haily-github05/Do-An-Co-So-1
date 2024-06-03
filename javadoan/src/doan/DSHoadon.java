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

import Dto.Hoadon;

public class DSHoadon extends JFrame {
	private static JTable tbl = new JTable();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private Connection connection;
	
	public DSHoadon() {
		setTitle("Quản Lý Bán Hàng - Cửa Hàng Quần Áo BRY" );
		setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel,BorderLayout.CENTER);
        Container container = getContentPane();
        
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setPreferredSize(new Dimension(690, 590));
        panel.add(panel1);
        JLabel jLabel_1 = new JLabel("Danh sách hoá đơn", JLabel.CENTER);
        Font font = new Font("Serif", Font.CENTER_BASELINE, 50);
        jLabel_1.setFont(font);
        jLabel_1.setBackground(Color.pink);
        jLabel_1.setOpaque(true);
        panel1.add(jLabel_1, BorderLayout.NORTH);
        
        
    	
    	JPanel pn2b= new JPanel();
    	pn2b.setBackground(Color.pink);  
        pn2b.setPreferredSize(new Dimension(690,10));
        JButton btntimkiem = new JButton("Tìm kiếm theo Mã");
    	JTextField txttimkiem= new JTextField(15);
    	panel1.add(pn2b); 
    	panel1.add(txttimkiem);
    	panel1.add(btntimkiem);
    	
    	JPanel pn2c= new JPanel();
    	pn2c.setBackground(Color.pink); 
    	pn2c.setPreferredSize(new Dimension(690,10));
    	JButton btntimkiem2 = new JButton("Tìm kiếm theo Ngày");
    	JDateChooser txttimkiem2 = new JDateChooser();
		txttimkiem2.setDateFormatString("yyyy-MM-dd");
		txttimkiem2.getJCalendar().setPreferredSize(new Dimension(350, 200));
		txttimkiem2.setBackground(Color.pink);
		txttimkiem2.setPreferredSize(new Dimension(178,25));
    	panel1.add(pn2c);
        panel1.add(txttimkiem2);
    	panel1.add(btntimkiem2);
    	
        
        DefaultTableModel dm=new DefaultTableModel();
        dm.addColumn("Mã hoá đơn");
        dm.addColumn("Ngày bán");
        dm.addColumn("Tổng tiền");
        tbl =new JTable(dm);
    	JScrollPane sc=new JScrollPane(tbl);
    	sc.setPreferredSize(new Dimension(680,300));
    	panel1.add(sc,BorderLayout.SOUTH);
    	showData(DBConnection.findAll333());
    	
    	JButton ql = new JButton("Quay lại");
    	ql.setVisible(false);   	
    	panel1.add(ql);
    	
    	JButton thoat = new JButton("Thoát");
    	thoat.setVisible(true);   	
    	panel1.add(thoat);
    	
    	btntimkiem.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				Hoadon hd = new Hoadon();
    				hd.setMahd(txttimkiem.getText());
    				showData(DBConnection.timkiem334(hd));
    				ql.setVisible(true);
    				ql.addActionListener(new ActionListener() {
    								@Override
    					public void actionPerformed(ActionEvent e) {
    						// TODO Auto-generated method stub
    						txttimkiem.setText("");
    						ql.setVisible(false);
    						showData(DBConnection.findAll333());
    					}
    				});	
    			}	
    	    });
    	btntimkiem2.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {   	    	
    	    	String ngay = sdf.format(txttimkiem2.getDate());
    	        Hoadon hd = new Hoadon();
    	        hd.setNgayban(ngay);    
    	        showData(DBConnection.timkiem333(hd));
    	        ql.setVisible(true);
				ql.addActionListener(new ActionListener() {
								@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						txttimkiem2.setDate(null);
						ql.setVisible(false);
						showData(DBConnection.findAll333());
					}
				});			
    	    }	
    	});
    	thoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
        DSHoadon hd = new DSHoadon();
        hd.setLocationRelativeTo(null);
        hd.setVisible(true);
    }
}

            
