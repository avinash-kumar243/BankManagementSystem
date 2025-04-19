package bank.management.system.pkg4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton deposit, back;
    JLabel text;
    
    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 760);
        add(image);
        
        text = new JLabel("Enter amount you want to deposit: ");
        text.setBounds(150, 280, 300, 30);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(160, 340, 245, 30);
        amount.setForeground(Color.BLACK);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(295, 430, 110, 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
        if(ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount is empty");
            } 
            try {
                Conn conn = new Conn();
                String query = "INSERT INTO bank VALUES('" + pinNumber + "', '" + date + "', 'Deposit', '" + number + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "₹" + number + " deposited successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Error while depositing");
            }        
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Deposit(""); 
    }
}
