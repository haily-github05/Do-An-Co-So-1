package TextFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class File1 {	
	public static void writeInvoiceToFile1(String mahd, String ngayban, int manv, String ghichu, String giamgia, String tong, String khachtra, String du, String filePath, JTable tbl3) {
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write("Mã hoá đơn: " + mahd + "\n");
            writer.write("Ngày bán: " + ngayban + "\n");
            writer.write("Mã nhân viên: " + manv + "\n");
            writer.write("Ghi chú: " + ghichu + "\n\n");

            DefaultTableModel model = (DefaultTableModel) tbl3.getModel();
            int rowCount = model.getRowCount();
            int columnCount = model.getColumnCount();
            
            int[] columnWidths = new int[columnCount];
            for (int col = 0; col < columnCount; col++) {
                int maxWidth = 0;
                String columnName = model.getColumnName(col);
                if (columnName.length() > maxWidth) {
                    maxWidth = columnName.length();
                }
                for (int row = 0; row < rowCount; row++) {
                    String cellValue = model.getValueAt(row, col).toString();
                    if (cellValue.length() > maxWidth) {
                        maxWidth = cellValue.length();
                    }
                }
                columnWidths[col] = maxWidth;
            }
            for (int col = 0; col < columnCount; col++) {
                String columnName = model.getColumnName(col);
                writer.write(String.format("%-" + (columnWidths[col] + 5) + "s", columnName));
            }
            writer.write("\n");
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < columnCount; col++) {
                    String cellValue = model.getValueAt(row, col).toString();
                    writer.write(String.format("%-" + (columnWidths[col] + 5) + "s", cellValue));
                }
                writer.write("\n");
            }

            writer.write("\nGiảm giá: " + giamgia + "\n");
            writer.write("Tổng: " + tong + "\n");
            writer.write("Khách trả: " + khachtra + "\n");
            writer.write("Khách dư: " + du + "\n");

            writer.close();
            System.out.println("Thông tin đã được lưu vào tệp " + filePath);
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi vào tệp.");
            e.printStackTrace();
        }
    }

	

}
