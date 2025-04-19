package bank.management.system.pkg4;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 760);
        add(image);
        
        JLabel text = new JLabel("Please Select your transaction");
        text.setBounds(170, 230, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(120, 348, 142, 28);
        deposit.setFont(new Font("Raleway", Font.BOLD, 13));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(313, 348, 142, 28);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 13));
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(120, 382, 142, 28);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 13));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(313, 382, 142, 28);
        miniStatement.setFont(new Font("Raleway", Font.BOLD, 13));
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(120, 416, 142, 28);
        pinChange.setFont(new Font("Raleway", Font.BOLD, 13));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(313, 416, 142, 28);
        balanceEnquiry.setFont(new Font("Raleway", Font.BOLD, 13));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(313, 449, 142, 28);
        exit.setFont(new Font("Raleway", Font.BOLD, 13));
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(800, 760);
        setLocation(300, 0);
        setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Transactions("");
    }
}
