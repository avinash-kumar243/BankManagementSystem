package bank.management.system.pkg4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JLabel l1, type, cardno, cardNumber, cardnoDis, pinno, pinNumber, pinnoDis, service; 
    JRadioButton depositeAc, savingAc, fixedAc, currentAc;
    JCheckBox atmCard, internetBanking, mobileBanking, msgAlert, chequeBook, eStatement, lastDisc;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 3");
        
        l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(220,30, 300, 35);
        add(l1);
        
        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(120, 100, 140, 25);
        add(type);
        
        savingAc = new JRadioButton("Saving Account");
        savingAc.setFont(new Font("Raleway", Font.BOLD, 12));
        savingAc.setBounds(120, 140, 130, 16);
        savingAc.setBackground(Color.WHITE);
        add(savingAc);
        
        fixedAc = new JRadioButton("Fixed Deposit Account");
        fixedAc.setFont(new Font("Raleway", Font.BOLD, 12));
        fixedAc.setBounds(385, 140, 170, 16);
        fixedAc.setBackground(Color.WHITE);
        add(fixedAc);
        
        currentAc = new JRadioButton("Current Account");
        currentAc.setFont(new Font("Raleway", Font.BOLD, 12));
        currentAc.setBounds(120, 170, 130, 16);
        currentAc.setBackground(Color.WHITE);
        add(currentAc);
        
        depositeAc = new JRadioButton("Recurring Deposit Account");
        depositeAc.setFont(new Font("Raleway", Font.BOLD, 12));
        depositeAc.setBounds(385, 170, 180, 16);
        depositeAc.setBackground(Color.WHITE);
        add(depositeAc);
        
        ButtonGroup btn1 = new ButtonGroup();
        btn1.add(savingAc);
        btn1.add(fixedAc);
        btn1.add(currentAc);
        btn1.add(depositeAc);

        cardno = new JLabel("Card Number");
        cardno.setBounds(120, 225, 160, 25);
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(cardno);
        
        cardNumber = new JLabel("XXXX-XXXX-XXXX-5468");
        cardNumber.setBounds(370, 225, 220, 22);
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        add(cardNumber);
        
        cardnoDis = new JLabel("Your 16 digit card number");
        cardnoDis.setBounds(120, 260, 160, 16);
        cardnoDis.setFont(new Font("Raleway", Font.BOLD, 12));
        add(cardnoDis);
        
        pinno = new JLabel("Pin Number");
        pinno.setBounds(120, 310, 160, 25);
        pinno.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinno);
        
        pinNumber = new JLabel("XXXX");
        pinNumber.setBounds(370, 310, 160, 25);
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pinNumber);
        
        pinnoDis = new JLabel("Your 4 digit pin number");
        pinnoDis.setBounds(120, 345, 160, 16);
        pinnoDis.setBackground(Color.WHITE);
        pinnoDis.setFont(new Font("Raleway", Font.BOLD, 12));
        add(pinnoDis);
        
        service = new JLabel("Services Required:");
        service.setBounds(120, 395, 200, 25);
        service.setFont(new Font("Raleway", Font.BOLD, 20));
        add(service);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(120, 435, 150, 16);
        atmCard.setFont(new Font("Raleway", Font.BOLD, 12));
        atmCard.setBackground(Color.WHITE);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBounds(385, 435, 150, 16);
        internetBanking.setFont(new Font("Raleway", Font.BOLD, 12));
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBounds(120, 475, 150, 16);
        mobileBanking.setFont(new Font("Raleway", Font.BOLD, 12));
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);
        
        msgAlert = new JCheckBox("Email & SMS Alerts");
        msgAlert.setBounds(385, 475, 150, 16);
        msgAlert.setFont(new Font("Raleway", Font.BOLD, 12));
        msgAlert.setBackground(Color.WHITE);
        add(msgAlert);
        
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBounds(120, 515, 150, 16);
        chequeBook.setFont(new Font("Raleway", Font.BOLD, 12));
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setBounds(385, 515, 150, 16);
        eStatement.setFont(new Font("Raleway", Font.BOLD, 12));
        eStatement.setBackground(Color.WHITE);
        add(eStatement);
        
        lastDisc = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        lastDisc.setFont(new Font("Raleway", Font.BOLD, 11));
        lastDisc.setBounds(120, 585, 580, 15);
        lastDisc.setBackground(Color.WHITE);
        add(lastDisc);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(210, 620, 100, 25);
        add(submit);
        submit.addActionListener(this);
                
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(380, 620, 100, 25);
        add(cancel);
        cancel.addActionListener(this);
        
        
        
        setSize(700, 720);
        setLocation(350, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(savingAc.isSelected()) {
                accountType = "Saving Account";
            } else if(fixedAc.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if(currentAc.isSelected()) {
                accountType = "Current Account";
            } else if(depositeAc.isSelected()) {
                accountType = "Recurring Deposit Account";
            }
            
            Random rm = new Random();
            String cardnumber = "" + Math.abs((rm.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((rm.nextLong() % 9000L) + 1000L);

//            cardNumber.setText(cardnumber);
//            pinNumber.setText(pinnumber);

            StringBuilder facility = new StringBuilder();
            if(atmCard.isSelected()) facility.append("ATM Card, ");
            if(internetBanking.isSelected()) facility.append("Internet Banking, ");
            if(mobileBanking.isSelected()) facility.append("Mobile Banking, ");
            if(msgAlert.isSelected()) facility.append("Email & SMS Alerts, ");
            if(chequeBook.isSelected()) facility.append("Cheque Book, ");
            if(eStatement.isSelected()) facility.append("E-Statement, ");
            if(facility.length() > 0) facility.setLength(facility.length() - 2);

            
            try {
                if(accountType == null) {
                    JOptionPane.showMessageDialog(null, "AccountType is required");
                } else if (!lastDisc.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please confirm the declaration");
                } else {
                    Conn c = new Conn();
                    String query1 = "INSERT INTO signup3 (formno, accountType, cardnumber, pin, facility) VALUES (?, ?, ?, ?, ?)";
                    
                    PreparedStatement ps = c.conn.prepareStatement(query1);
                    ps.setString(1, formno);
                    ps.setString(2, accountType);
                    ps.setString(3, cardnumber);
                    ps.setString(4, pinnumber);
                    ps.setString(5, facility.toString());
                    
                    ps.executeUpdate();
                    
                    String query2 = "INSERT INTO login (formno, cardnumber, pin) VALUES (?, ?, ?)";
                    
                    PreparedStatement ps2 = c.conn.prepareStatement(query2);
                    ps2.setString(1, formno);
                    ps2.setString(2, cardnumber);
                    ps2.setString(3, pinnumber);
                    
                    ps2.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPIN: " + pinnumber);
                        
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
    new SignupThree("1234");
}

}
