package bank.management.system.pkg4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton withdrawl, back;
    JLabel text;
    
    Withdrawl(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 760);
        add(image);
        
        text = new JLabel("Enter amount you want to withdraw: ");
        text.setBounds(150, 280, 300, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(160, 340, 245, 30);
        amount.setForeground(Color.BLACK);
        image.add(amount);
        
        withdrawl = new JButton("Withdraw");
        withdrawl.setBounds(295, 430, 110, 25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(160, 430, 110, 25);
        back.addActionListener(this);
        image.add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700, 720);
        setLocation(350, 20);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount is empty");
            } 
            try {
                Conn conn = new Conn();
                
                ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                int withdrawAmount = Integer.parseInt(number);
                if(balance < withdrawAmount) {
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                    return;
                }
                
                String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'Withdrawl', '" + number + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹" + number + " Withdrawl successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error while withdrawling");
            }        
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Withdrawl(""); 
    }
}
