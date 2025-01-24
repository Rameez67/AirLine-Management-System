import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {

    JLabel lbName, tfName, lbNationality, tfnation, lbAdhar, tfadhar, lbAddress, tfAddress, lbGender, tDate, fCode,
            flCode,
            fName, flName, tfGender, lbSource, lbDest;
    JTextField tfAdhar;
    JButton fetchButton, fetch, bookFlight;
    Choice source, destination;
    JDateChooser dcDate;

    public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1100, 700);
        setLocation(200, 100);
        setVisible(true);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Raileway", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        lbAdhar = new JLabel("Adhaar Number");
        lbAdhar.setBounds(60, 55, 150, 25);
        lbAdhar.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAdhar);

        tfAdhar = new JTextField();
        tfAdhar.setBounds(220, 55, 200, 25);
        add(tfAdhar);

        fetchButton = new JButton("Fetch User");
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

        lbNationality = new JLabel("Nationality");
        lbNationality.setBounds(60, 135, 150, 25);
        lbNationality.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbNationality);

        tfnation = new JLabel();
        tfnation.setBounds(230, 135, 150, 25);
        tfnation.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfnation);

        lbAddress = new JLabel("Address");
        lbAddress.setBounds(60, 170, 150, 25);
        lbAddress.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAddress);

        tfAddress = new JLabel();
        tfAddress.setBounds(230, 170, 150, 25);
        tfAddress.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tfAddress);

        lbGender = new JLabel("Gender");
        lbGender.setBounds(60, 225, 150, 25);
        lbGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbGender);

        tfGender = new JLabel();
        tfGender.setBounds(230, 225, 150, 25);
        tfGender.setFont(new Font("Raleway", Font.BOLD, 16));
        add(tfGender);

        lbSource = new JLabel("Source");
        lbSource.setBounds(60, 270, 150, 25);
        lbSource.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbSource);

        source = new Choice();
        source.setBounds(220, 270, 200, 25);
        // source.add("Rameez");
        add(source);

        lbDest = new JLabel("Destination");
        lbDest.setBounds(60, 325, 150, 25);
        lbDest.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbDest);

        destination = new Choice();
        destination.setBounds(220, 325, 200, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                source.add(rs.getString("f_source"));
                destination.add(rs.getString("f_destination"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        fetch = new JButton("Fetch Flights");
        fetch.setBounds(440, 325, 120, 25);
        fetch.setBackground(Color.BLACK);
        fetch.setForeground(Color.WHITE);
        fetch.addActionListener(this);
        add(fetch);

        fName = new JLabel("Flight Name");
        fName.setBounds(60, 360, 150, 25);
        fName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(fName);

        flName = new JLabel();
        flName.setBounds(230, 360, 150, 25);
        flName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(flName);

        fCode = new JLabel("Flight Code");
        fCode.setBounds(60, 395, 150, 25);
        fCode.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(fCode);

        flCode = new JLabel();
        flCode.setBounds(230, 395, 150, 25);
        flCode.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(flCode);

        tDate = new JLabel("Date of Travel");
        tDate.setBounds(60, 430, 150, 25);
        tDate.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(tDate);

        dcDate = new JDateChooser();
        dcDate.setBounds(220, 430, 150, 25);
        dcDate.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(dcDate);

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/icons/details.jpg"));
        Image i2 = il.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lbImage = new JLabel(image);
        lbImage.setBounds(550, 55, 500, 350);
        add(lbImage);

        bookFlight = new JButton("Book Flight");
        bookFlight.setBounds(220, 465, 120, 25);
        bookFlight.setBackground(Color.BLACK);
        bookFlight.setForeground(Color.WHITE);
        bookFlight.addActionListener(this);
        add(bookFlight);
    }

    public void actionPerformed(ActionEvent ae) {

        if (fetchButton == ae.getSource()) {
            String adhar = tfAdhar.getText();

            try {
                Conn conn = new Conn();
                String query = "select * from passenger where adhar='" + adhar + "'";
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    tfName.setText(rs.getString("name"));
                    tfnation.setText(rs.getString("nation"));
                    // tfadhar.setText(rs.getString("adhar"));
                    tfAddress.setText(rs.getString("address"));
                    tfGender.setText(rs.getString("gender"));

                } else {
                    JOptionPane.showMessageDialog(null, " Please Enter the correct CNIC");
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (fetch == ae.getSource()) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "select * from flight where f_source = '" + src + "' and f_destination ='" + dest + "'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    flName.setText(rs.getString("f_name"));
                    flCode.setText(rs.getString("f_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please Enter the valide source and Destination");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            Random random = new Random();
            String name = tfName.getText();
            String nation = tfnation.getText();
            String adhar = tfAdhar.getText();
            String fname = flName.getText();
            String fcode = flCode.getText();
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            String ddate = ((JTextField) dcDate.getDateEditor().getUiComponent()).getText();

            try {
                Conn c = new Conn();
                String query = "insert into reservation values('PNR-" + random.nextInt(1000000) + "','TIC-"
                        + random.nextInt(10000) + "','" + name + "','" + nation + "','" + adhar + "','" + fname + "','"
                        + fcode + "','" + src + "','" + dest + "','" + ddate + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new BookFlight();
    }
}
