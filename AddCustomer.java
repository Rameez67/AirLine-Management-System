import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfName, tfNationality, tfAdhar, tfAddress, tfPhone;
    JRadioButton rbMale, rbFemale;
    JButton save;

    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);

        JLabel heading = new JLabel("ADD CUSTOMERS DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Raileway", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lbName = new JLabel("Name");
        lbName.setBounds(60, 55, 150, 25);
        lbName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbName);

        tfName = new JTextField();
        tfName.setBounds(220, 55, 200, 25);
        add(tfName);

        JLabel lbNationality = new JLabel("Nationality");
        lbNationality.setBounds(60, 100, 150, 25);
        lbNationality.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbNationality);

        tfNationality = new JTextField();
        tfNationality.setBounds(220, 100, 200, 25);
        add(tfNationality);

        JLabel lbAdhar = new JLabel("Aadhar Number");
        lbAdhar.setBounds(60, 135, 150, 25);
        lbAdhar.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAdhar);

        tfAdhar = new JTextField();
        tfAdhar.setBounds(220, 135, 200, 25);
        add(tfAdhar);

        JLabel lbAddress = new JLabel("Address");
        lbAddress.setBounds(60, 170, 150, 25);
        lbAddress.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220, 170, 200, 25);
        add(tfAddress);

        JLabel lbGender = new JLabel("Gender");
        lbGender.setBounds(60, 205, 150, 25);
        lbGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbGender);

        rbMale = new JRadioButton("Male");
        rbMale.setBounds(220, 205, 70, 25);
        rbMale.setBackground(Color.WHITE);
        add(rbMale);

        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(300, 205, 70, 25);
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);

        ButtonGroup gendeGroup = new ButtonGroup();

        gendeGroup.add(rbMale);
        gendeGroup.add(rbFemale);

        JLabel lbPhone = new JLabel("Phone");
        lbPhone.setBounds(60, 240, 150, 25);
        lbPhone.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lbPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220, 240, 200, 25);
        add(tfPhone);

        save = new JButton("Save");
        save.setBounds(220, 275, 200, 25);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/icons/emp.png"));
        JLabel lbImage = new JLabel(image);
        lbImage.setBounds(450, 55, 300, 450);
        add(lbImage);

    }

    public void actionPerformed(ActionEvent ae) {

        String name = tfName.getText();
        String address = tfAddress.getText();
        String nation = tfNationality.getText();
        String adhar = tfAdhar.getText();
        String phone = tfPhone.getText();
        String gender = null;
        if (rbMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        try {
            Conn conn = new Conn();
            String query = "insert into passenger values('" + name + "','" + address + "','" + nation + "','" + adhar
                    + "','" + phone + "','" + gender + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Detail Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
