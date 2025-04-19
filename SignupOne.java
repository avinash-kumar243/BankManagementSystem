package bank.management.system.pkg4;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;


public class SignupOne extends JFrame implements ActionListener {

    long random;
    JTextField nameTextField, fatherTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JRadioButton male, female, yes, no, other;
    JLabel formno, personalDetails, name, fatherName, dob, gender, email, marital, address, city, state, pincode;
    JDateChooser date;

    SignupOne() {
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L + 1000L);

        formno = new JLabel("Application form no: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 35));
        formno.setBounds(130, 10, 450, 42);
        add(formno);

        personalDetails = new JLabel("Page 1 : Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(215, 55, 300, 30);
        add(personalDetails);

        name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 125, 180, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(285, 125, 305, 30);
        add(nameTextField);

        fatherName = new JLabel("Father's Name: ");
        fatherName.setFont(new Font("Raleway", Font.BOLD, 20));
        fatherName.setBounds(100, 175, 180, 30);
        add(fatherName);

        fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fatherTextField.setBounds(285, 175, 305, 30);
        add(fatherTextField);

        dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 225, 180, 30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(285, 225, 305, 30);
        add(date);

        gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 275, 180, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(290, 275, 70, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(405, 275, 75, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup btngp = new ButtonGroup();
        btngp.add(male);
        btngp.add(female);

        email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 325, 180, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(285, 325, 305, 30);
        add(emailTextField);

        marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100, 375, 180, 30);
        add(marital);

        yes = new JRadioButton("Yes");
        yes.setBounds(290, 375, 50, 30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(407, 375, 50, 30);
        no.setBackground(Color.WHITE);
        add(no);

        other = new JRadioButton("Other");
        other.setBounds(515, 375, 80, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup btngrp = new ButtonGroup();
        btngrp.add(yes);
        btngrp.add(no);
        btngrp.add(other);

        address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 425, 180, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(285, 425, 305, 30);
        add(addressTextField);

        city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 475, 180, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(285, 475, 305, 30);
        add(cityTextField);

        state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 525, 180, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(285, 525, 305, 30);
        add(stateTextField);

        pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 575, 180, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pincodeTextField.setBounds(285, 575, 305, 30);
        add(pincodeTextField);

        JButton next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBounds(500, 625, 82, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(700, 720);
        setLocation(350, 20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ac) {
    String formno = "" + random;
    String name = nameTextField.getText();
    String fname = fatherTextField.getText();

    Date selectedDate = date.getDate();
    String dob = "";
    if (selectedDate != null) {
        dob = new SimpleDateFormat("dd-MM-yyyy").format(selectedDate);
    }

    String gender = "";
    if (male.isSelected()) {
        gender = "Male";
    } else if (female.isSelected()) {
        gender = "Female";
    }

    String email = emailTextField.getText();

    String marital = "";
    if (yes.isSelected()) {
        marital = "Yes";
    } else if (no.isSelected()) {
        marital = "No";
    } else if (other.isSelected()) {
        marital = "Other";
    }

    String address = addressTextField.getText();
    String city = cityTextField.getText();
    String state = stateTextField.getText();
    String pincode = pincodeTextField.getText();

    try {
    if (name.equals("")) {
        JOptionPane.showMessageDialog(null, "Name is required");
    } else if (fname.equals("")) {
        JOptionPane.showMessageDialog(null, "Father's name is required");
    } else if (selectedDate == null) {
        JOptionPane.showMessageDialog(null, "Please select a date of birth");
    } else if (gender.equals("")) {
        JOptionPane.showMessageDialog(null, "Please select your gender");
    } else if (email.equals("")) {
        JOptionPane.showMessageDialog(null, "Email is required");
    } else if (marital.equals("")) {
        JOptionPane.showMessageDialog(null, "Please select marital status");
    } else if (address.equals("")) {
        JOptionPane.showMessageDialog(null, "Address is required");
    } else if (city.equals("")) {
        JOptionPane.showMessageDialog(null, "City is required");
    } else if (state.equals("")) {
        JOptionPane.showMessageDialog(null, "State is required");
    } else if (pincode.equals("")) {
        JOptionPane.showMessageDialog(null, "Pincode is required");
    } else {
        Conn c = new Conn();
        String query = "INSERT INTO signup (formno, name, fname, dob, gender, email, marital, address, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = c.conn.prepareStatement(query);
        pstmt.setString(1, formno);
        pstmt.setString(2, name);
        pstmt.setString(3, fname);
        pstmt.setString(4, dob);
        pstmt.setString(5, gender);
        pstmt.setString(6, email);
        pstmt.setString(7, marital);
        pstmt.setString(8, address);
        pstmt.setString(9, city);
        pstmt.setString(10, state);
        pstmt.setString(11, pincode);

        pstmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Details saved successfully!");
        
        
//        String formno1 = this.formno;
        setVisible(false);
        new SignupTwo(formno);

        // Proceed to next step
    }
} catch (Exception e) {
    e.printStackTrace();
}


}


    public static void main(String args[]) {
        new SignupOne();
    }
}
