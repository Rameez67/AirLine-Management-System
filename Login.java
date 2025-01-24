import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton reset, submit, close;
    JTextField userfield;
    JPasswordField passwordField;

    public Login() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(500, 250);
        setLocation(600, 250);

        JLabel username = new JLabel("Username");
        username.setBounds(20, 20, 100, 20);
        username.setFont(new Font("Raleway", Font.BOLD, 16));
        add(username);

        userfield = new JTextField();
        userfield.setBounds(120, 20, 200, 30);
        add(userfield);

        JLabel password = new JLabel("Password");
        password.setBounds(20, 60, 100, 20);
        password.setFont(new Font("Raleway", Font.BOLD, 16));
        add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 60, 200, 30);
        add(passwordField);

        reset = new JButton("Reset");
        reset.setBounds(80, 100, 100, 30);
        reset.setFont(new Font("Raleway", Font.BOLD, 16));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(220, 100, 100, 30);
        submit.setFont(new Font("Raleway", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(90, 140, 200, 30);
        close.setFont(new Font("Raleway", Font.BOLD, 16));
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = userfield.getText();
            String password = new String(passwordField.getPassword()); // Use getPassword() for password fields

            try {
                Conn c = new Conn();
                String query = "select * from login where username = '" + username + "' and password = '"
                        + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) {
            userfield.setText("");
            passwordField.setText("");
        }
    }

    public static void main(String[] args) {

        new Login();

    }
}