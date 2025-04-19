package bank.management.system.pkg4;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, adharTextField;
    JRadioButton seniorYes, seniorNo, accountYes, accountNo;
    JComboBox religionBox, incomeBox, occupationBox, catagoryBox, educationalBox;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(215, 55, 300, 30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 125, 180, 30);
        add(religion);

        String[] options = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionBox = new JComboBox(options);
        religionBox.setBounds(285, 125, 305, 30);
        religionBox.setBackground(Color.WHITE);
        religionBox.setFont(new Font("Arial", Font.BOLD, 14));
        add(religionBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 175, 180, 30);
        add(category);

        String[] cat = {"General", "OBC", "EBC", "SC", "ST", "Other"};
        catagoryBox = new JComboBox(cat);
        catagoryBox.setFont(new Font("Raleway", Font.BOLD, 14));
        catagoryBox.setBounds(285, 175, 305, 30);
        catagoryBox.setBackground(Color.WHITE);
        add(catagoryBox);

        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 225, 180, 30);
        add(income);

        String[] inc = {"NULL", "<50,000", "<1,00,000", "<5,00,000", "<10,00,000", ">10,00,000"};
        incomeBox = new JComboBox(inc);
        incomeBox.setFont(new Font("Raleway", Font.BOLD, 14));
        incomeBox.setBounds(285, 225, 305, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel educational = new JLabel("Educational ");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 285, 180, 30);
        add(educational);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 180, 30);
        add(qualification);

        String[] edu = {"NULL", "School", "Non graduation", "Graduation", "Post Graduation", "Doctorate", "Others"};
        educationalBox = new JComboBox(edu);
        educationalBox.setFont(new Font("Raleway", Font.BOLD, 14));
        educationalBox.setBounds(285, 300, 305, 30);
        educationalBox.setBackground(Color.WHITE);
        add(educationalBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 375, 180, 30);
        add(occupation);

        String[] occu = {"Employee", "Self-Employed", "Businessman", "Student", "Service", "Retired", "Others"};
        occupationBox = new JComboBox(occu);
        occupationBox.setFont(new Font("Raleway", Font.BOLD, 14));
        occupationBox.setBounds(285, 375, 305, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel pan = new JLabel("Pan no: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 425, 180, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(285, 425, 305, 30);
        add(panTextField);

        JLabel adhar = new JLabel("Adhar no: ");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 475, 180, 30);
        add(adhar);

        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        adharTextField.setBounds(285, 475, 305, 30);
        add(adharTextField);

        JLabel seniorCitizon = new JLabel("Senior Citizen: ");
        seniorCitizon.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizon.setBounds(100, 525, 180, 30);
        add(seniorCitizon);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(320, 525, 80, 30);
        seniorYes.setFont(new Font("Raleway", Font.BOLD, 15));
        seniorYes.setBackground(Color.WHITE);
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(480, 525, 80, 30);
        seniorNo.setFont(new Font("Raleway", Font.BOLD, 15));
        seniorNo.setBackground(Color.WHITE);
        add(seniorNo);

        ButtonGroup btn1 = new ButtonGroup();
        btn1.add(seniorYes);
        btn1.add(seniorNo);

        JLabel existingAccountLabel = new JLabel("Existing Account: ");
        existingAccountLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccountLabel.setBounds(100, 575, 180, 30);
        add(existingAccountLabel);

        accountYes = new JRadioButton("Yes");
        accountYes.setBounds(320, 575, 80, 30);
        accountYes.setFont(new Font("Raleway", Font.BOLD, 15));
        accountYes.setBackground(Color.WHITE);
        add(accountYes);

        accountNo = new JRadioButton("No");
        accountNo.setBounds(480, 575, 80, 30);
        accountNo.setFont(new Font("Raleway", Font.BOLD, 15));
        accountNo.setBackground(Color.WHITE);
        add(accountNo);

        ButtonGroup btn2 = new ButtonGroup();
        btn2.add(accountYes);
        btn2.add(accountNo);

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

    public void actionPerformed(ActionEvent ae) {
    String religionStr = (String) religionBox.getSelectedItem();
    String catagoryStr = (String) catagoryBox.getSelectedItem();
    String incomeStr = (String) incomeBox.getSelectedItem();
    String educationStr = (String) educationalBox.getSelectedItem();
    String occupationStr = (String) occupationBox.getSelectedItem();
    String panStr = panTextField.getText();
    String adharStr = adharTextField.getText();

    String seniorStr = seniorYes.isSelected() ? "Yes" : seniorNo.isSelected() ? "No" : null;
    String accountStr = accountYes.isSelected() ? "Yes" : accountNo.isSelected() ? "No" : null;

    // Print collected values
    System.out.println("Collected data:");
    System.out.println(religionStr + ", " + catagoryStr + ", " + incomeStr + ", " + educationStr + ", "
            + occupationStr + ", " + panStr + ", " + adharStr + ", " + seniorStr + ", " + accountStr);

    try {
        if (religionStr.equals("") || catagoryStr.equals("") || incomeStr.equals("") || educationStr.equals("")
                || occupationStr.equals("") || panStr.equals("") || adharStr.equals("")
                || seniorStr == null || accountStr == null) {
            JOptionPane.showMessageDialog(null, "Please fill all required fields.");
        } else {
            Conn c = new Conn(); // your existing DB connection class
            String query = "INSERT INTO signup2 (formno, religion, category, income, education, occupation, pan, adhar, seniorCitizen, existingAccount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = c.conn.prepareStatement(query);
            ps.setString(1, formno);
            ps.setString(2, religionStr);
            ps.setString(3, catagoryStr);
            ps.setString(4, incomeStr);
            ps.setString(5, educationStr);
            ps.setString(6, occupationStr);
            ps.setString(7, panStr);
            ps.setString(8, adharStr);
            ps.setString(9, seniorStr);
            ps.setString(10, accountStr);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Details saved successfully!");
            
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
    }
}


    public static void main(String[] args) {
        new SignupTwo("");
    }
   
}
 