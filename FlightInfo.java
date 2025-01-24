import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900, 500);
        setLocation(400, 200);
        setVisible(true);

        JTable table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            // 2d array = [rows][colomns]
            // rows =0 columns 0;
            // for(){
            // for(){
            // arr[row][column]= data;
            // col++
            // }
            // row++;
            // }
        } catch (Exception e) {
            System.out.println(e);
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 900, 500);
        add(jsp);

    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
