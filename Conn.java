package bank.management.system.pkg4;

import java.sql.*;

public class Conn {
    public Connection conn;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // for MySQL 8+
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "USERNAME", "PASSWORD");
            // Replace USERNAME and PASSWORD with your actual DB credentials
            s = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
