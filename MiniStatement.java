package bank.management.system.pkg4;


//import java.awt.Color;
import java.awt.*;
//import java.awt.Image;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;
//import java.awt.event.*;
//import java.sql.ResultSet;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinNumber) {
        
        JLabel mini = new JLabel();
//        mini.setBounds(40, 160, 350, 400);
//        mini.setFont(new Font("System", Font.PLAIN, 12));
        add(mini);
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel text = new JLabel("Indian Bank");
        text.setBounds(140, 30, 130, 20);
        text.setFont(new Font("System", Font.BOLD, 18));
        add(text);
        
        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(70, 90, 250, 20);
        cardNumber.setFont(new Font("System", Font.BOLD, 14));
        add(cardNumber);
        
        JLabel balance = new JLabel();
        balance.setBounds(80, 70, 480, 20);
        balance.setFont(new Font("System", Font.BOLD, 18));
        add(balance);
        
        try {
            Conn conn = new Conn();
            int bal = 0;
            
            ResultSet rs = conn.s.executeQuery("SELECT cardNumber FROM login WHERE pin = '"+pinNumber+"'");
            while(rs.next()) {
                cardNumber.setText("Card Number: " + rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12, 16));
                if(rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current account balance is " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinNumber + "'");
            while(rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
            }

        } catch (Exception e) {
            System.out.println("Transaction fetch error: " + e);
        }
        
        mini.setBounds(20, 160, 400, 200);
        
        setSize(450, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]) {
        new MiniStatement("").setVisible(true);
    }
}
