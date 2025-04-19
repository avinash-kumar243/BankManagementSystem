package bank.management.system.pkg4;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton rs5000, rs10000, rs2000, rs1000, rs500, rs100, back, deposit, withdraw, exit;
    String pinNumber;
    
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 760);
        add(image);
        
        JLabel text = new JLabel("Please Select Withdrawl Amount");
        text.setBounds(170, 230, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        rs100 = new JButton("Rs 100");
        rs100.setBounds(120, 348, 142, 28);
        rs100.setFont(new Font("Raleway", Font.BOLD, 13));
        rs100.addActionListener(this);
        image.add(rs100);
        
        rs500 = new JButton("Rs 500");
        rs500.setBounds(313, 348, 142, 28);
        rs500.setFont(new Font("Raleway", Font.BOLD, 13));
        rs500.addActionListener(this);
        image.add(rs500);
        
        rs1000 = new JButton("Rs 1000");
        rs1000.setBounds(120, 382, 142, 28);
        rs1000.setFont(new Font("Raleway", Font.BOLD, 13));
        rs1000.addActionListener(this);
        image.add(rs1000);
        
        rs2000 = new JButton("Rs 2000");
        rs2000.setBounds(313, 382, 142, 28);
        rs2000.setFont(new Font("Raleway", Font.BOLD, 13));
        rs2000.addActionListener(this);
        image.add(rs2000);
        
        rs5000 = new JButton("Rs 5000");
        rs5000.setBounds(120, 416, 142, 28);
        rs5000.setFont(new Font("Raleway", Font.BOLD, 13));
        rs5000.addActionListener(this);
        image.add(rs5000);
        
        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(313, 416, 142, 28);
        rs10000.setFont(new Font("Raleway", Font.BOLD, 13));
        rs10000.addActionListener(this);
        image.add(rs10000);
        
        back = new JButton("Back");
        back.setBounds(313, 449, 142, 28);
        back.setFont(new Font("Raleway", Font.BOLD, 13));
        back.addActionListener(this);
        image.add(back);    
                
        setSize(800, 760);
        setLocation(300, 0);
        setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹" + amount + " Withdrawl successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
}
