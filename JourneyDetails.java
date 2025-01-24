import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
    JTable table;
    JLabel lblpnr;
    JTextField pnr;

    public JourneyDetails() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900, 500);
        setLocation(400, 200);
        setVisible(true);

        lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);

        pnr = new JTextField();
        pnr.setBounds(160, 50, 150, 25);
        add(pnr);

        JButton show = new JButton("Show");
        show.setBounds(310, 50, 100, 25);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(this);
        add(show);

        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 500);
        jsp.setBackground(Color.WHITE);
        add(jsp);

    }

    public void actionPerformed(ActionEvent ae) {

        try {

            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from reservation where PNR = '" + pnr.getText() + "'");
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Information Not Found");
                return;
            }
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
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
