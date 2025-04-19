package bank.management.system.pkg4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 760);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(320, 430, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        int balance = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equals("Deposit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            System.out.println("Balance fetch error: " + e);
        }
        
        JLabel text = new JLabel("Your current account balance is: Rs " + balance);
        text.setBounds(140, 300, 325, 30);
        text.setFont(new Font("System", Font.BOLD, 13));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        setSize(800, 760);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("").setVisible(true);
    }
}
