import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class BoardingPass extends JFrame implements ActionListener {

    JLabel lbName, tfName, lbNationality, tfnation, lbAdhar, tfadhar, lbAddress, lblsrc, lbGender, tDate, fCode,
            flCode,
            fName, flName, lbldest, lbldate;
    JTextField tfpnr;
    JButton fetchButton, fetch, bookFlight;

    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 20, 350, 35);
        heading.setFont(new Font("Raileway", Font.PLAIN, 32));
        add(heading);

        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 60, 350, 30);
        subheading.setFont(new Font("Raileway", Font.PLAIN, 32));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        lbAdhar = new JLabel("PNR Number");
        lbAdhar.setBounds(60, 100, 150, 25);
        lbAdhar.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAdhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 200, 25);
        add(tfpnr);

        fetchButton = new JButton("Enter");
        fetchButton.setBounds(440, 100, 120, 25);
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.addActionListener(this);
        add(fetchButton);

        lbName = new JLabel("Name");
        lbName.setBounds(60, 135, 150, 25);
        lbName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbName);

        tfName = new JLabel();
        tfName.setBounds(230, 135, 150, 25);
        tfName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfName);

        lbNationality = new JLabel("Nationality");
        lbNationality.setBounds(60, 170, 150, 25);
        lbNationality.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbNationality);

        tfnation = new JLabel();
        tfnation.setBounds(230, 170, 150, 25);
        tfnation.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfnation);

        lbAddress = new JLabel("Src");
        lbAddress.setBounds(60, 205, 150, 25);
        lbAddress.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAddress);

        lblsrc = new JLabel();
        lblsrc.setBounds(230, 205, 150, 25);
        lblsrc.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblsrc);

        lbGender = new JLabel("Dest");
        lbGender.setBounds(60, 240, 150, 25);
        lbGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbGender);

        lbldest = new JLabel();
        lbldest.setBounds(230, 240, 150, 25);
        lbldest.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lbldest);

        fName = new JLabel("Flight Name");
        fName.setBounds(60, 370, 275, 25);
        fName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(fName);

        flName = new JLabel();
        flName.setBounds(230, 370, 150, 25);
        flName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(flName);

        fCode = new JLabel("Flight Code");
        fCode.setBounds(60, 310, 150, 25);
        fCode.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(fCode);

        flCode = new JLabel();
        flCode.setBounds(230, 310, 150, 25);
        flCode.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(flCode);

        tDate = new JLabel("Date of Travel");
        tDate.setBounds(60, 345, 150, 25);
        tDate.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tDate);

        lbldate = new JLabel();
        lbldate.setBounds(220, 345, 150, 25);
        lbldate.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbldate);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/icons/airindia.png"));
        Image i2 = il.getImage().getScaledInstance(350, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lbImage = new JLabel(image);
        lbImage.setBounds(550, 0, 350, 300);
        add(lbImage);

    }

    public void actionPerformed(ActionEvent ae) {

        if (fetchButton == ae.getSource()) {
            String pnr = tfpnr.getText();

            try {
                Conn conn = new Conn();
                String query = "select * from reservation where PNR='" + pnr + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfnation.setText(rs.getString("nation"));
                    // tfadhar.setText(rs.getString("adhar"));
                    lblsrc.setText(rs.getString("src"));
                    lbldate.setText(rs.getString("ddate"));
                    lbldest.setText(rs.getString("dest"));
                    flName.setText(rs.getString("fname"));
                    flCode.setText(rs.getString("fcode"));

                } else {
                    JOptionPane.showMessageDialog(null, " Please Enter the correct CNIC");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
