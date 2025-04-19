package bank.management.system.pkg4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        setLayout(null);
        
        setTitle("Automatic Taylor Machine");
        setSize(640, 450);
        setLocation(240, 120);
        
        // Add logo
        ImageIcon i1 = new ImageIcon("C:\\Users\\91628\\OneDrive\\Documents\\NetBeansProjects\\Bank Management System 4\\src\\icons\\logo.jpg");

        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(80, 10, 100, 100); 
        add(label);

        getContentPane().setBackground(Color.WHITE);
        
        JLabel text = new JLabel("Welcome to the ATM");
        text.setFont(new Font("Osward", Font.BOLD, 30));
        text.setBounds(200, 50, 320, 30);
        add(text);
        
        JLabel cardno = new JLabel("Card no: ");
        cardno.setFont(new Font("raleway", Font.BOLD, 20));
        cardno.setBounds(150, 150, 320, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(280, 150, 170, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("raleway", Font.BOLD, 20));
        pin.setBounds(150, 200, 340, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(280, 200, 170, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton("Sign In");
        login.setBounds(170, 270, 110, 30);
        login.setFont(new Font("Arial", Font.BOLD, 18));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("Clear");
        clear.setBounds(320, 270, 110, 30);
        clear.setFont(new Font("Arial", Font.BOLD, 18));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        add(clear);
        
        signup = new JButton("Sign Up");
        signup.setBounds(170, 320, 260, 30);
        signup.setFont(new Font("Arial", Font.BOLD, 18));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);

        add(signup);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == login) {
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            Conn con = new Conn();
            String query = "SELECT * FROM login WHERE cardNumber = '" + cardNumber + "' AND pin = '" + pinNumber + "'";
            try {
                ResultSet r = con.s.executeQuery(query);
                if(r.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN Number"); 
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if(ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == signup) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Login();
    }
}

