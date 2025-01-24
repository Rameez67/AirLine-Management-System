import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class Cancel extends JFrame implements ActionListener {

    JLabel lbName, tfName, lbNationality, cancellationno, lbAdhar, tfadhar, lbAddress, lblfcode, lbGender, lbldate;
    JTextField tfpnr;
    JButton fetchButton, fetch;

    public Cancel() {

        Random random = new Random();
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);

        JLabel heading = new JLabel("Cancellation");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Raileway", Font.PLAIN, 32));
        add(heading);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/icons/cancel.jpg"));
        Image i2 = il.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 100, 250, 250);
        add(image);

        lbAdhar = new JLabel("PNR Number");
        lbAdhar.setBounds(60, 55, 150, 25);
        lbAdhar.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAdhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 55, 200, 25);
        add(tfpnr);

        fetchButton = new JButton("Show Details");
        fetchButton.setBounds(440, 55, 120, 25);
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.addActionListener(this);
        add(fetchButton);

        lbName = new JLabel("Name");
        lbName.setBounds(60, 100, 150, 25);
        lbName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbName);

        tfName = new JLabel();
        tfName.setBounds(230, 100, 150, 25);
        tfName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfName);

        lbNationality = new JLabel("Cancellation");
        lbNationality.setBounds(60, 135, 150, 25);
        lbNationality.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbNationality);

        cancellationno = new JLabel("" + random.nextInt(1000000));
        cancellationno.setBounds(230, 135, 150, 25);
        cancellationno.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(cancellationno);

        lbAddress = new JLabel("Flight Code");
        lbAddress.setBounds(60, 170, 150, 25);
        lbAddress.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAddress);

        lblfcode = new JLabel();
        lblfcode.setBounds(230, 170, 150, 25);
        lblfcode.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblfcode);

        lbGender = new JLabel("Date of Travel");
        lbGender.setBounds(60, 225, 150, 25);
        lbGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbGender);

        lbldate = new JLabel();
        lbldate.setBounds(230, 225, 150, 25);
        lbldate.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lbldate);

        fetch = new JButton("Cancel Flights");
        fetch.setBounds(220, 260, 120, 25);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);

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
                    lblfcode.setText(rs.getString("fcode"));
                    lbldate.setText(rs.getString("ddate"));

                } else {
                    JOptionPane.showMessageDialog(null, " Please Enter the correct CNIC");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (fetch == ae.getSource()) {
            String name = tfName.getText();
            String pnr = tfpnr.getText();
            String cancel = cancellationno.getText();
            String fcode = lblfcode.getText();
            String date = lbldate.getText();

            try {
                Conn c = new Conn();
                String query = "insert into cancel values('" + name + "','" + pnr + "','" + cancel + "','" + fcode
                        + "','" + date + "')";
                c.s.executeUpdate(query);
                c.s.executeUpdate("delete from reservation where PNR = '" + pnr + "'");
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

    public static void main(String[] args) {
        new Cancel();
    }
}
